<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <h3>Ajax Gson Test</h3>
    <input type="button" value="text결과" id="ajaxBtn" />
    <input type="button" value="json결과" id="jsonBtn" />

    <input type="button" value="DTO결과" id="dtoBtn" />
    <input type="button" value="List결과" id="listBtn" />
    <input type="button" value="Map결과" id="mapBtn" />

    <input type="button" value="textJson결과" id="textJsonBtn" />

    <hr />
    <div id="display"></div>

    <script>
      const baseURL = `${pageContext.request.contextPath}`;

      document.getElementById("ajaxBtn").addEventListener("click", async () => {
        console.log("ajaxBtn 누름");
        try {
          let response = await fetch(`${"${baseURL}/ajax"}`, {
            method: "POST",
            body: new URLSearchParams({ key: "text" }),
          });
          if (!response.ok) throw new Error("text요청 실패" + response.status);
          console.log(response);
          let result = await response.text();
          console.log(result);
          document.getElementById("display").innerHTML = `<h4>${"${result}"}</h4>`;
        } catch (error) {
          console.log(err);
          document.getElementById("display").innerHTML = `<h4>${"${err}"}</h4>`;
        }
      });
      /////////////////////////////////////////////////////////////////////////////////////////

      document.getElementById("jsonBtn").addEventListener("click", async () => {
        console.log("jsonBtn 누름");
        try {
          let response = await fetch(`${"${baseURL}/ajax"}`, {
            method: "POST",
            body: new URLSearchParams({ key: "json" }),
          });
          if (!response.ok) throw new Error("json요청 실패" + response.status);
          console.log(response);
          let result = await response.json();
          console.log(result);
          let str = "";
          result.forEach((menu, index) => {
            str += `<input type='checkbox' name="menu" value="${"${index}"}">${"${menu}"}`;
          });
          document.getElementById("display").innerHTML = str;
        } catch (error) {
          console.log(err);
          document.getElementById("display").innerHTML = `<h4>${"${err}"}</h4>`;
        }
      });

      document.getElementById("dtoBtn").addEventListener("click", async () => {
        console.log("dtoBtn 누름");
        try {
          let response = await fetch(`${"${baseURL}/ajax"}`, {
            method: "POST",
            body: new URLSearchParams({ key: "dto" }),
          });
          if (!response.ok) throw new Error("json요청 실패" + response.status);
          console.log(response);
          let result = await response.json();
          console.log(result);
          document.getElementById("display").innerHTML = result.id + " | " + result.name;
        } catch (error) {
          console.log(err);
          document.getElementById("display").innerHTML = `<h4>${"${err}"}</h4>`;
        }
      });

      document.getElementById("listBtn").addEventListener("click", async () => {
        console.log("listBtn 누름");
        try {
          let response = await fetch(`${"${baseURL}/ajax"}`, {
            method: "POST",
            body: new URLSearchParams({ key: "list" }),
          });
          if (!response.ok) throw new Error("json요청 실패" + response.status);
          console.log(response);
          let result = await response.json();
          console.log(result);
          let str = "";
          result.forEach((member, index) => {
            str += member.id + " | " + member.name + " | " + member.age + " | " + member.addr + "<br>";
          });
          document.getElementById("display").innerHTML = str;
        } catch (error) {
          console.log(err);
          document.getElementById("display").innerHTML = `<h4>${"${err}"}</h4>`;
        }
      });

      document.getElementById("mapBtn").addEventListener("click", async () => {
        console.log("ajaxBtn 누름");
        try {
          let response = await fetch(`${"${baseURL}/ajax"}`, {
            method: "POST",
            body: new URLSearchParams({ key: "map" }),
          });
          if (!response.ok) throw new Error("json요청 실패" + response.status);
          console.log(response);
          let result = await response.json();
          console.log(result);
          let str = "";
          str += result.message + "<br>";
          str += result.dto.id + " | " + result.dto.name + " | " + result.dto.age + " | " + result.dto.addr + "<br>";

          result.memberList.forEach((member, index) => {
            str += member.id + " | " + member.name + " | " + member.age + " | " + member.addr + "<br>";
          });
          str += result.pageNo;
          document.getElementById("display").innerHTML = str;
        } catch (error) {
          console.log(err);
          document.getElementById("display").innerHTML = `<h4>${"${err}"}</h4>`;
        }
      });

      document.getElementById("textJsonBtn").addEventListener("click", async () => {
        console.log("textJsonBtn 누름");
      });
    </script>
  </body>
</html>
