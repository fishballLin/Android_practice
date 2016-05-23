*	實做Implicit Broadcast (MainActivity.java為sender MainReceiver.java為receiver)

*	在AndroidManifest.xml中註冊receiver的intent-filter時要注意，每個action都要包在不同intent-filter中

*	當收到廣播時，有三種不同的處理方式(Toast, Dialog, Notify)

*	Dialog的背景是透明的(達到看不出有跳轉到另一個activity的效果)
	
	-	在colors.xml新增一個color
	
	-	在styles.xml新增一個style
	
	-	把AppCompatActivity改成Activity(因為前者規定使用android:theme="@style/AppTheme"，不能使用自訂的主題) 
	
	-	請參考[傳送門](http://stackoverflow.com/questions/2176922/how-to-create-transparent-activity-in-android)
