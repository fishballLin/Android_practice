*	若我們使用在Manifest中定義intent-filter來接收ACTION_BATTERY_CHANGED，我們將不會收到這個Action，詳見[官網](https://developer.android.com/reference/android/content/Intent.html#ACTION_BATTERY_CHANGED)。因此利用Context.registerReceiver動態註冊receiver，即可處理這個問題了

*	此外有一個問題是要在Activity生命週期的哪個階段「註冊」和「反註冊」，原本我是想要在onCreate註冊、onDestroy反註冊，不過我發現一個問題就是"有時當App結束後，onDestroy並不會被忽叫"，而這個在[overstack](http://stackoverflow.com/questions/4449955/activity-ondestroy-never-called)找到了解答。

*	因此我在onResume註冊receiver，而在onPause反註冊receiver，