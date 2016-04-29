# README 城市攻略 #

**目标用户**：为了了解这座城市的人，初来城市的人

**需求分析**：为了知道这里城市的人文地理，快速融入这座城市。
刚毕业的学生为了工作而来；努力打拼的工作者为了出差而来；潇洒的旅行者为拜访名胜古迹莫名而来；睿智的投资人为了寻找更大的财富而来；.......
总之，对这城市了解的越多越好，这将是您的求职的目的，旅行的意义，.......

APP NAME : 城市攻略  Demo V1.1

**功能点：**

- 攻略衣篇
- 攻略食篇
- 攻略住篇
- 攻略行篇
- 攻略工作篇（企业篇）

启动界面：
欢迎界面，采用倒计时5秒的方式，跳转到主界面。

功能界面：

1. 攻略 从五点衣、食、住、行、企业了解城市。
1. 换城 选择城市，切换要去的目标城市。
1. 更多 问题的反馈，或攻略的共享。

【攻略】

标题头：点位城市

图片栏：推荐当前城市五个风景胜地

五个菜单栏：攻略的核心内容部分，这里只有Dome部分。点击后跳转查看内容，目前内容较少。这里可以用户参与分享攻略。提供更多的更好的经验。

【换城】

列出热门城市

列出当前选择的城市

提供支持的城市列表供选择


【更多】

反馈问题提交，发送邮件到作者

软件的版本信息


--------------

编写代码遇到的一些问题点：

遇到的问题点：

1.问题Fragment区别，导入包错误，很浪费时间？	
 fragmentTransaction.add(R.id.content, conquestFragment);	//此处报错		
import android.app.Fragment;  //使用此包
import android.support.v4.app.Fragment; 

2.问题AAPT err(Facade for 131044): libpng error: Not a PNG file		

libpng error: Not a PNG file
　　这个错误是将图片的JPG格式后缀改为PNG，到了Linux系统下编译不能通过，才造成的；
　　解决方案如下：
　　使用PS软件，重新将该图片格式化另存为PNG，则可以通过编译。
注意：在存放图片时千万不要将格式为.jpg的图片改成.png格式，千万不要偷懒，一定要将格式转换成PNG格式的图片，否则编译将不通过。切记！！！！

3.Error:(11) Error retrieving parent for item: No resource found that matches the given name 'Theme.AppCompat.Light.DarkActionBar'.
后来发现这个是eclipse的bug，如果你引用的库和你的代码不在一个盘符，就有此异常。
我的代码在E盘，appCompact的库在D盘，我从新将其移动到E盘就ok。

4.cannot resolve symbol ActionBarActivity

5.
cannot resolve symbol R
谷歌了一下，找到解决方法如下：谷歌了一下，找到解决方法如下：

Build -> Clean Project
Tools -> Android -> Sync Project With Gradle Files

6.Error:(11) Error retrieving parent for item: No resource found that matches the given name 'Theme.AppCompat.Light.DarkActionBar'.

//04.26完成框架

7.使用背景mine_info_item_bg.xml 报错。最后放弃使用。
java.lang.reflect.InvocationTargetException
 Caused by: android.content.res.Resources$NotFoundException: File res/drawable/mine_info_item_bg.xml from drawable resource ID #0x7f020067
 android:background="@drawable/mine_info_item_bg"
Caused by: android.content.res.Resources$NotFoundException: File res/drawable/mine_info_item_bg.xml from drawable resource ID #0x7f020067


设计资料图片：工程目录下 huzhou\城市攻略设计草稿
