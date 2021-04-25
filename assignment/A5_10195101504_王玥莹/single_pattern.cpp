/*   单例模式（饿汉）   */
/*    获取 IP地址和端口     */

#include <iostream>
using namespace std;

class Configsingleton
{
	public:
		static Configsingleton& GetInstance()  // 用公有接口获取该对象
		{
			return sinst;
		}
		
		void print()  // 打印 IP和 端口 
		{
			cout << "IP: " << ip << endl << "Port: " << port << endl;
		}
		
	private:
		const char* ip;
		int port;
		
		static Configsingleton sinst;  // 定义一个自定义类型的对象
		
		Configsingleton(const char* ip,int port)  // 私有构造函数
			: ip(ip)
			, port(port)
		{
		}
	
		Configsingleton(const Configsingleton&) = delete;  // 防止拷贝构造函数
		Configsingleton& operator=(const Configsingleton&) = delete;  // 防止运算符重载
	
};

// 在类外定义对象 sinst
Configsingleton Configsingleton::sinst("192.168.0.1", 67);

int main()
{
	// 获取该对象并打印
	Configsingleton::GetInstance().print();
	return 0;
}
