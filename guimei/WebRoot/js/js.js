var startBtn=document.getElementById('startgame');
var stopBtn=document.getElementById('stopgame');
stopBtn.disabled = true;
var gametime=document.getElementById("gametime");
var staytime=document.getElementById("staytime");
var showtime=document.getElementById("showtime");
var starttime;
var clearRemainTime,clearShowMouse;

function startGame(){
	starttime= new Date();
	init();
	remainTime();
}
//初始化
function init(){
	startBtn.disabled=true;
	gametime.disabled=true;
	staytime.disabled=true;
	showtime.disabled=true;
	stopBtn.disabled=false;
	//showMouse();
	clearShowMouse=window.setInterval("showMouse()", parseFloat(showtime.value)*1000);
	
}
//给每一张图片添加一个okclick事件
function initOnClick(){
	var imgs=document.images;
	for(var i=0;i<imgs.length;i++){
		m=function (j){
			imgs[i].onclick=function(){
				hitMouse(j);
		};
		}(i);
	}
	
}
function hitMouse(j){
	var src=document.images[j].src;
	alert(src.substring(src.lastIndexOf('/')+1));
	
}
//剩余时间
function remainTime (){
	var currenttime= new Date();//当前时间
	//游戏运行的时间为
	var runtime=(currenttime-starttime)/1000;
	//获取游戏的时间
	var time=gametime.value;
	//讲时间格式化
	var s=Math.round(parseFloat(time)* 60-runtime);
	document.getElementById("daojishi").innerHTML=s;
	if(s>0){
		window.setTimeout("remainTime()", 1000);
	}
	
}
//显示地鼠
function showMouse(){
	var i=parseInt(Math.random()*25);
	document.images[i].src="images/01.jpg";
	window.setTimeout("clearMouse("+i+")", parseFloat(staytime.value)*1000);
	
}
//
function clearMouse(i){
	
	document.images[i].src="images/00.jpg";
	
	
}

function stopGame(){
	startBtn.disabled=false;
	gametime.disabled=false;
	staytime.disabled=false;
	showtime.disabled=false;
	stopBtn.disabled=true;
	window.clearTimeout(clearRemainTime);
	window.clearTimeout(clearShowMouse);
}