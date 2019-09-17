function showTime(){
//	a=1;
//	alert(a);
	var date=new Date();
	var h=date.getHours();
	var m=date.getMinutes();
	var s=date.getSeconds();
//	alert(h+":"+m+":"+s);
	document.getElementById("time").innerHTML=h+":"+m+":"+s;
	setTimeout('showTime()',1000);
	
}