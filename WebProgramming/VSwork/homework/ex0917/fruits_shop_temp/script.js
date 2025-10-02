// DOM 요소
const fruitList = document.getElementById("fruitList");
const veggieList = document.getElementById("veggieList");

const searchBox = document.getElementById("searchBox");
const sortSelect = document.getElementById("sortSelect");
const loadMoreBtn = document.getElementById("loadMoreBtn");

let veggiePage = 0;

// 카드 렌더링 함수
function renderProducts(data, container) {
  //data는 과일 또는 야채의 배열
  //container는 fruitList나 veggieList....
  container.innerHTML = "";
  data.forEach((item) => {
    container.innerHTML += `
      <div class="col-md-4">
        <div class="card h-100 shadow-sm">
        <a href="detail.html?id=${item.id}" class="text-decoration-none text-dark">
          <img src="${item.img}" class="card-img-top" alt="${item.name}">
          <div class="card-body text-center">
            <h5 class="card-title">${item.name}</h5>
            <p class="card-text text-primary fw-bold">${item.price.toLocaleString()}원</p>
          </div>
          </a>
        </div>
      </div>`;
  });
}

// 과일 출력
function filterAndSortFruits() {
  let keyword = searchBox.value.trim(); //공백제거
  //공백 제거후 includes로 포함하는지 체크
  let filtered = fruits.filter((f) => f.name.includes(keyword));
  //정렬
  if (sortSelect.value === "low") {
    filtered.sort((a, b) => a.price - b.price);
  } else if (sortSelect.value === "high") {
    filtered.sort((a, b) => b.price - a.price);
  } else if (sortSelect.value === "name") {
    filtered.sort((a, b) => a.name.localeCompare(b.name));
  }

  renderProducts(filtered, fruitList);
}

// 채소 출력 (3개씩 증가)
function loadVeggies() {
  const start = veggiePage * 3;
  const end = start + 3;

  const nextItems = veggies.slice(0, end);
  veggiePage++;
  if (end >= veggies.length) {
    loadMoreBtn.style.display = "none";
  }

  renderProducts(nextItems, veggieList);
}

// 이벤트 리스너
searchBox.addEventListener("input", filterAndSortFruits);
sortSelect.addEventListener("change", filterAndSortFruits);
loadMoreBtn.addEventListener("click", loadVeggies);

// 초기 실행
filterAndSortFruits();
loadVeggies();
