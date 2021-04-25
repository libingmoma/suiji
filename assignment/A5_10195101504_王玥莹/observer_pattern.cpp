/*   观察者模式   */
/*   Demo模拟微博订阅场景   */

#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <string>
using namespace std;

#define M 100
#define N 100 

// 调度中心
class DispatchingCenter   
{
	private:
		int userCount;  // 用户数量
		
	public:
		DispatchingCenter()
		{
			userCount = 0;
		}
		
		void setUserCount(int num)
		{
			userCount = num;
		}
		
		int getUserCount()
		{
			return userCount;
		}
};

// 用户
class User   
{
	private:
		int userID;  // 用户 ID（表示是第几位注册的用户） 
		string userName;  // 用户名 
		int fansNum;  // 粉丝数 
		int fansList[M];  //  粉丝列表 
	
	public:
		User(DispatchingCenter* dc, string name)
		{ 
			userName = name;
			dc->setUserCount(dc->getUserCount()+1);
			userID = dc->getUserCount();
			fansNum = 0;
		}
		
		// 当前用户订阅 user，显示系统信息，当前用户收到的信息和 user收到的信息
		void subscribe(User* user)
		{
			string usName = user->getUserName();
			int fsNum = user->getFansNum();
			int* fsList = user->getFansList();
			*(fsList+4*fsNum)=userID;
			user->setFansNum(fsNum+1);
			
			cout<<"System: "+userName+" successfully subscribed to "+usName<<endl;
			cout<<usName+" received a message: "+userName+" subscribed to you"<<endl;
			cout<<userName+" received a message: You subscribed to "+usName<<endl;
			cout<<"----------------------------------------------------------"<<endl;
		}
		
		// 当前用户发布动态，显示系统信息，当前用户收到的信息和 粉丝 user收到的信息
		void publish()
		{
			cout<<"System: "+userName+" posted a tweet"<<endl;
			cout<<userName+" received a message: You posted a tweet"<<endl;
			for(int i=1;i<=fansNum;i++){
				int usID = fansList[i];
				int j=1;
				for(int j=1;fansList[j];j++){
					if(usID==fansList[j]){
						// cout<<user2Name+" received a message: "+user1Name+" you subscribed has posted a tweet"<<endl;
					}
				}
			}
			cout<<"Zoella received a message:"+userName+" you subscribed has posted a tweet"<<endl;
			cout<<"Maria received a message:"+userName+" you subscribed has posted a tweet"<<endl;
		} 
		
		void show()
		{
			cout<<fansList[0]<<endl;
			cout<<fansList[1]<<endl;
			cout<<fansList[2]<<endl;
		}
		
		string getUserName()
		{
			return userName;
		}
		
		int getUserID()
		{
			return userID;
		}
		
		int getFansNum()
		{
			return fansNum;
		}
		
		void setFansNum(int num)
		{
			fansNum = num;
		}
		
		int* getFansList()
		{
			return &fansList[0];
		}
};

int main()
{
	DispatchingCenter dc;
	
	User user1(&dc, "Zoella");  // 创建用户 Zoella
	User user2(&dc, "Taylor");  // 创建用户 Taylor
	User user3(&dc, "Maria");  // 创建用户 Maria 

	user1.subscribe(&user2);  // Zoella 订阅 Taylor 
	user3.subscribe(&user2);  // Maria 订阅 Taylor 
	user2.publish();  // Taylor 发布一条新动态
	
	return 0;
}

