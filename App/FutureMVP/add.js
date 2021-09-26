document.addEventListener('DOMContentLoaded',
    () => {
        const button = document.getElementById('btnSaveCocktail');
        button.addEventListener('click', 
            (event) => {
                event.preventDefault();
                processAdd();
            }
        );
    }
);

function processAdd() {

    let nameV =  document.getElementById('name').value;
    let ingredientsV = document.getElementById('ingredients').value;
    let recipeV = document.getElementById('recipe').value;


    const newCocktail = {
        name : `${nameV}`,
        ingredients : `${ingredientsV}`,
        recipe : `${recipeV}`
    }

    fetch("http://localhost:8080/drinks", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }, 
        body: JSON.stringify(newCocktail)

    })
    .then(response => response.json())
        .then((data) => {
            window.alert("New Cocktail successfully saved!");
        })
        .catch((error) => {
            console.log(error);
            // console.error("An error has occurred. Please try again later.", error);
        });

}        
