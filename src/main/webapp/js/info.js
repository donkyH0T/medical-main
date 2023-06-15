function start() {
    const pageTitle = window.location.search;
    let url;
    let text = document.getElementById("text");
    if (pageTitle === "?SOFA") {
        url = "/calculator/SOFA/info";
    }
    if (pageTitle === "?GRACE") {
        url = "/calculator/GRACE/info";
    }
    if (pageTitle === "?Child-pugh") {
        url = "/calculator/Child-Pugh/info";
    }
    fetch(url)
        .then(response => response.json())
        .then(data => text.innerHTML = data.info)
        .catch(error => console.error(error));
}

start();

