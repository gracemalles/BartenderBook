
//import axios from 'axios';

let cocktails = [];

document.addEventListener('DOMContentLoaded',() => {
    loadCocktailMenu();
    // const desc = document.querySelector('.description');
    // desc.addEventListener('click', (event) => {
    //   toggleDescriptionEdit(event.target);
    // });

})

function loadCocktailMenu(){
    fetch("http://localhost:8080/all")
  
    
    .then((response) => {    //.then handles the promise - -response object
        let json = response.json();  // turn the response object into json
        // console.log(json);
        return json;
      })
      .then((data) => {  // take the promise result and turn it into data
        // console.log(data);
        cocktails = data;
        console.log(cocktails);
        displayCocktails();
      })

}

function displayCocktails() {
    if('content' in document.createElement('template')) {
        cocktails.forEach((cocktail) => {
            displayCocktailMenu(cocktail);
        });
    } else {
        console.error('An error has occurred. Please try again later')
    }
}

function displayCocktailMenu(cocktail) { 
    const main = document.getElementById('main');
    const tmpl = document.getElementById('cocktail-template').content.cloneNode(true);
    tmpl.querySelector('h3').innerText = cocktail.name;
    tmpl.querySelector('h4').innerText = cocktail.ingredients;
    tmpl.querySelector('p').innerText = cocktail.recipe;
    main.appendChild(tmpl);
}
// // delete cocktail 
// function deleteCocktail(name){

// }