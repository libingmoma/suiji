/*   发布订阅者模式   */
/*   Demo模拟微博订阅场景   */
 
#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <string>
using namespace std;

#define M 100
#define N 100
int userCount = 0;  // 用户数 
string nameList[M];  // 用户名列表 

// 用户
class User   
{
	private:
		int userID;  // 用户 ID（表示是第几位注册的用户） 
		string userName;  // 用户名 
		int fansNum;  // 粉丝数 
	
	public:
		User(string name)
		{ 
			userName = name;
			userID = ++userCount;
			nameList[userCount]=name;
			fansNum = 0;
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
};

// 调度中心
class DispatchingCenter   
{
	private:
		int idList[M][N];  // 横坐标表示用户 ID，纵坐标表示订阅某用户的用户ID 
		
	public:
		DispatchingCenter()
		{
			for(int i=1;i<=userCount;i++)
			{
				idList[i][0] = i;
			}
		}

		// user1 订阅 user2，显示系统信息，user2收到的信息和 user1收到的信息 
		void subscribe(User* user1, User* user2)  
		{
			string user1Name = user1->getUserName();
			string user2Name = user2->getUserName();
			int user1ID = user1->getUserID();
			int user2ID = user2->getUserID();
			for(int i=1;i<M;i++){
				if(idList[i][0]==user2ID){
					user2->setFansNum(user2->getFansNum()+1);
					idList[i][user2->getFansNum()] = user1ID;
					break;
				}
			}
			cout<<"System: "+user1Name+" successfully subscribed to "+user2Name<<endl;
			cout<<user2Name+" received a message: "+user1Name+" subscribed to you"<<endl;
			cout<<user1Name+" received a message: You subscribed to "+user2Name<<endl;
			cout<<"----------------------------------------------------------"<<endl;
		}
		
		// user1 发布动态，显示系统信息，user1收到的信息和 user2收到的信息
		void publish(User user1)   
		{
			string user1Name = user1.getUserName();
			int user1ID = user1.getUserID();
			cout<<"System: "+user1Name+" posted a tweet"<<endl;
			cout<<user1Name+" received a message: You posted a tweet"<<endl;
			int i = 1;
			while(idList[user1ID][i])
			{
				int user2ID = idList[user1ID][i];
				string user2Name = nameList[user2ID];
				cout<<user2Name+" received a message: "+user1Name+" you subscribed has posted a tweet"<<endl;
				i++;
			}
		}
};

int main()
{
	User user1("Zoella");  // 创建用户 Zoella
	User user2("Taylor");  // 创建用户 Taylor
	User user3("Maria");  // 创建用户 Maria 

	DispatchingCenter dc;
	dc.subscribe(&user1, &user2);  // Zoella 订阅 Taylor 
	dc.subscribe(&user3, &user2);  // Maria 订阅 Taylor 
	dc.publish(user2);  // Taylor 发布一条新动态 
	
	return 0;
}

