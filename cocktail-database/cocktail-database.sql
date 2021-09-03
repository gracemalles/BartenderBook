drop table if exists cocktails;

BEGIN TRANSACTION;

CREATE TABLE cocktails (
        cocktail_id serial,
        cocktail_name varchar(64) NOT null,
        ingredients varchar(200) NOT null,
        recipe varchar(500) NOT null,
        
        constraint pk_cocktails primary key (cocktail_id)
         
         );
         
COMMIT TRANSACTION; 

BEGIN TRANSACTION;

INSERT INTO cocktails (cocktail_name, ingredients, recipe)
VALUES('Cosmopolitan', 
'2 oz vodka, 1 oz triple sec, 1 oz cranberry juice, 0.5 oz cranberry juice', 
'Pour all ingredients into a cocktail shaker with ice. Shake well and pour through a strainer into chilled martini glass. Garnish with lime wedge');

INSERT INTO cocktails (cocktail_name, ingredients, recipe)
VALUES('Martini', 
'3 oz gin, 0.5 oz dry vermouth',
'Pour all ingredients into a cocktail shaker with ice. Shake well and strain into a chilled cocktail glass. Garnish with olives');


INSERT INTO cocktails (cocktail_name, ingredients, recipe)
VALUES('Old Fashioned', 
'2 oz bourbon, 2 dashes Angostura bitter, 1 sugar cube', 
'Muddle the sugar cube and bitters with one bar spoon of water at the bottom of a chilled rocks glass. Add bourbon. Stir. Add 1 large ice sube. Stir. Garnish with orange twist');


INSERT INTO cocktails (cocktail_name, ingredients, recipe)
VALUES('Negroni',
'1 oz gin, 1 oz campari, 1 oz sweet vermouth',
'Add the gin, Campari and sweet vermouth to a mixing glass filled with ice, and stir until well-chilled. Strain into rocks glass with large ice cube. Garnish with orange peel');

INSERT INTO cocktails (cocktail_name, ingredients, recipe)
VALUES('Manhattan',
'2 oz bourbon, 1 oz sweet vermouth, 2 dashes Angostura bitters, 1 dash orange bitters',
'Add ingredients to a mixing glass with ice, and stir until well-chilled. Strain into chilled coupe. Garnish with cherry');

COMMIT TRANSACTION;