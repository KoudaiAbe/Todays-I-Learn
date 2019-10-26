//HTMLからidを使ってボタンのクリックイベントを取得する
//resetボタンをクリックしたらpointにリセットを返す
document.getElementById("reset").onclick = function(){
	document.getElementById("point").innerHTML = "リセット";
};
