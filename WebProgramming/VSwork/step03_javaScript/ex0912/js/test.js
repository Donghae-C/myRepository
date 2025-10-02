// 여기서부터는 자바스크립트 영역입니다.
/*부분 or 여러줄 주석*/

//브라우저에 출력
//document.write("<h1>출력</h1>");
//콘솔 출력
console.log("출력");

//h1태그를 클릭하면 css를 적용하고 싶다. 함수를 작성
function test(th) {
  th.style.backgroundColor = "blue";
  th.style.color = "white";
}
//<h2>태그에 onmouseover, onmouseout이벤트를 만들고싶다.
//1.h2를 찾는다.(dom 즉 h2객체를 찾는다)
console.log(document.getElementById("h2"));
//문서가 생성되기 전에 접근하니 null값이 뜸.

console.log(document.getElementById("h2"));

document.getElementById("h2").onmouseover = function () {
  this.style.textDecoration = "underline";
};
document.getElementById("h2").onmouseout = function () {
  this.style.textDecoration = "none";
};

/*onload = function(){
      }
      */
