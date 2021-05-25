package com.example.demo.util;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class IdGeneratorUtils {
    private final long workerId = 0;
    private final long datacenterId = 0;
    private long sequence = 0L;

    private final long twepoch = 1288834974657L;

    private final long workerIdBits = 8L;
    private final long datacenterIdBits = 2L;
    private final long maxWorkerId = ~(-1L << workerIdBits);
    private final long maxDatacenterId = ~(-1L << datacenterIdBits);
    private final long sequenceBits = 12L;

    private final long workerIdShift = sequenceBits;
    private final long datacenterIdShift = sequenceBits + workerIdBits;
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    private final long sequenceMask = ~(-1L << sequenceBits);

    private long lastTimestamp = -1L;

    public volatile static IdGeneratorUtils instance = new IdGeneratorUtils();

    /*
     * workerId是机器ID，datacenterId是数据中心ID或机房ID。
     * 这都是为分布式而设置的，workerId每台机器肯定不一样，最大值由maxWorkerId限制。
     */
    private IdGeneratorUtils() {

    }

    public static IdGeneratorUtils getInstance() {
        if (instance == null) {
            synchronized (IdGeneratorUtils.class) {
                if (instance == null) {
                    instance = new IdGeneratorUtils();
                }
            }
        }
        return instance;
    }

    @PostConstruct
    public void init() {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(
                    String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        System.out.println(String.format(
                "worker starting. timestamp left shift %d, datacenter id bits %d, worker id bits %d, sequence bits %d, workerid %d",
                timestampLeftShift, datacenterIdBits, workerIdBits, sequenceBits, workerId));
    }

    public synchronized long nextId() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            long delay = lastTimestamp - timestamp;
            System.out.println("等待时间追平" + delay);
            try {
                Thread.sleep(delay + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timestamp = timeGen();
        }

        if (timestamp == lastTimestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return (((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift)
                | (workerId << workerIdShift) | sequence);
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

}