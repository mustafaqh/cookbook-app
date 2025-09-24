package cookbook;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import cookbook.connection.ConnectionUtil;

public class CreateRecipes {
  static Connection connection = ConnectionUtil.connectDB();

  public static void main(String[] args) {
    String sql;

    try (
        Statement stmt = connection.createStatement();) {

      System.out.println("Inserting into the table...");

      sql = "INSERT INTO recipes (name,short_description,description,steps) VALUES ('Caponata pasta','Easy to prepare', 'Whip up our easy vegetarian caponata pasta in just 20 minutes. It is simple to make,\n budget friendly and packs three of your five a day into one delicious meal', 'STEP 1:\n"
          +
          "Heat the oil in a large pan and cook the onion for 8-10 mins until starting to caramelise.\n Add the garlic for the final 2 mins of cooking time.\n STEP 2:\n"
          +
          "Tip in the mixed veg, tomatoes, capers and raisins. \n Season well and simmer, uncovered, for 10 mins, or until\n you have a rich sauce.\n STEP 3:\n"
          +
          "Meanwhile, boil the kettle. Pour the kettleful of water into a large pan with\n a little salt and bring back to the boil. Add the pasta and cook until\n tender with a little bite, then drain, reserving some of the pasta water.\n Tip the pasta into the sauce, adding a splash of pasta water \n if it needs loosening. Scatter with the basil leaves and parmesan,\n if you like, and serve straight from the pan')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO recipes (name,short_description,description,steps) VALUES ('Apple sour cream cake','Taking long time but it deserve it','Celebrate seasonal ingredients and bake this easy apple sponge cake. This Polish\n recipe uses soured cream for a moist sponge and a tot of rum.','STEP 1:\n"
          +
          "Peel, deseed and cut the apples into eighths. Pour the lemon\n juice over the apples and sprinkle with a little caster sugar\n so that they do not darken.\n STEP 2:\n"
          +
          "Heat the oven to 190C/fan 170C/gas 5. Beat the eggs with the remaining\n caster sugar in a mixer until you have a thick, pale, \nmousse-like mixture. Sift over the flour and baking powder, \n and fold it in followed by the soured cream, rum and butter.\n STEP 3:\n"
          +
          "Butter the inside of a 23cm springform tin and arrange the apples\n on the base. Spoon the batter on top and level it with a spatula.\n Put the cake in the oven and bake for 50 minutes-1 hour without\n opening the door. Cool the cake and then turn it out onto a plate,\n and sprinkle it with icing sugar to finish.')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO recipes (name,short_description,description,steps) VALUES ('Vegetarian lasagne','A very delicious dish','Make our easy vegetarian lasagne using just a handful of ingredients."
          +
          " You can use\nready-made tomato sauce and white sauce, or batch cook he sauces and freeze them.', 'STEP 1:\n To make the tomato sauce, heat "
          +
          " the olive oil in a saucepan.\n Add the onions, garlic and carrot. Cook for 5-7 mins over a\n medium heat " +
          " until softened. Turn up the heat a little and stir\n in the tomato purée. Cook for 1 min, pour in the " +
          " white wine,\n then cook for 5 mins until this has reduced by two-thirds.\n Pour over the chopped tomatoes "
          +
          " and add the basil leaves.\n Bring to the boil then simmer for 20 mins. Leave to cool then \n whizz in a food "
          +
          " processor. Will keep, cooled, \n  in the fridge for up to three days or frozen for three months.\n STEP 2:\n To make "
          +
          " the white sauce, melt the butter in a saucepan,\n stir in the plain flour, then cook for 2 mins. Slowly \n whisk in "
          +
          " the milk, then bring to the boil, stirring. Turn down\n the heat, then cook until the sauce starts to thicken and coats\n "
          +
          " the back of a wooden spoon. Will keep, cooled,\n in the fridge for up to three days or frozen for three months. "
          +
          "\n STEP 3:\n Heat the oven to 200C/180C fan/gas 6. Lightly oil two large\n baking trays and add the peppers "
          +
          " and aubergines.\n Toss with the olive oil, season well, then roast \n for 25 mins until lightly " +
          " browned.\n STEP 4:\n Reduce the oven to 180C/160C fan/gas 4. Lightly oil a\n 30 x 20cm ovenproof dish. " +
          " Arrange a layer \n of the vegetables on the bottom, then pour over a third \n f the tomato sauce. " +
          " Top with a layer of lasagne sheets,\n then drizzle over a quarter of the white sauce. Repeat\n until you " +
          " have three layers of pasta.\n STEP 5:\n Spoon the remaining white sauce over the pasta,\n making sure " +
          " the whole surface is covered, then\n scatter over the mozzarella and cherry tomatoes.\n Bake for " +
          " 45 mins until bubbling and golden.\n')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO recipes (name,short_description,description,steps) VALUES ('Halloumi & quinoa fattoush','Easy to prepare','With griddled halloumi,"
          +
          " toasted pitta pieces, grains, tomatoes, dill and mint, \nthis Middle Eastern-inspired salad makes a speedy"
          +
          " and satisfying lunch for four','STEP 1:\nHeat the grill to high. Toss the pitta pieces with 1 tbsp oil and"
          +
          "spread out onto a baking sheet.\nGrill for 3-4 mins, turning halfway, until golden and crisp." +
          " Set aside to cool.\nSTEP 2:\nMeanwhile, whisk together the remaining oil with the lemon juice and garlic," +
          " then\nseason. Heat a large griddle pan or non-stick frying pan over a high heat and\ncook the halloumi for 1-2 mins on each side or"
          +
          " until lightly charred.\nSTEP 3:\nCook the quinoa following pack instructions, leave to cool, then toss with the tomatoes, \ncucumber, spring onion, "
          +
          " most of the fresh herbs and the dressing. Season to taste.\nTip onto a serving plate and top with the halloumi, pitta and remaining herbs.')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO recipes (name,short_description,description,steps) VALUES ('Fruity mocktail','A refreshing drink','Make this fruit-flavoured mocktail with grenadine "
          +
          "and orange juice to serve as a non-\nalcoholic drink option at a family party. It is more fun with grape and blueberry\n "
          +
          "stirrers that double as a snack','STEP 1:\nThread the grapes and blueberries onto the skewers to make stirrers."
          +
          "\nSTEP 2:\nPour the grenadine into four glasses. Gently tip the glasses and pour the\norange juice down the inside of the "
          +
          "glasses so it sits on top of the grenadine.\nTop up with sparking water, and add the stirrers to serve.')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO recipes (name,short_description,description,steps) VALUES ('Peanut butter cookies','A very delicious cookies','With just "
          +
          "three ingredients, these simple peanut butter cookies will delight\nkids and grown-ups alike – and they are gluten-free, "
          +
          "too.','STEP 1:\nHeat oven to 180C/160C fan/gas 4 and line 2 large baking trays with baking parchment.\nSTEP 2:\nMeasure "
          +
          "the peanut butter and sugar into a bowl. Add ¼ tsp fine table salt and\nmix well with a wooden spoon. Add the egg "
          +
          "and mix again until the mixture\nforms a dough.\nSTEP 3:\nBreak off cherry tomato sized chunks of dough and place, well spaced apart, "
          +
          "on\nthe trays. Press the cookies down with the back of a fork to squash them a little.\nThe cookies can now be frozen for 2 months, cook from frozen adding "
          +
          "an\nextra min or 2 to the cooking time.\nSTEP 4:\nBake for 12 mins, until golden around the edges and paler in the centre. Cool on\nthe trays for 10 mins, then transfer to a wire rack "
          +
          "and cool completely. Store in a\ncookie jar for up to 3 days.\n')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO recipes (name,short_description,description,steps) VALUES ('One-pan pasta', 'Saves time','Save on washing up with this easy and "
          +
          "quick one-pan spaghetti dish with\n meatballs and a tomato sauce. It is both healthy and low in calories. " +
          "','STEP 1:\n Heat the oil in a deep, wide frying pan or casserole dish over a medium-high heat.\n Tip in the meatballs "
          +
          " and cook for 5 mins, turning until browned all over. Add the\n onion and garlic, and fry for 8 more mins until "
          +
          " softened.\nSTEP 2:\nAdd the ketchup, chopped tomatoes, chopped basil and 400ml water to the\npan and bring to the boil. "
          +
          " Add the spaghetti and cook for 10-12 mins,\nstirring occasionally. When the pasta is cooked and the sauce has "
          +
          " reduced,\nseason and sprinkle with the basil leaves to serve.')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO recipes (name,short_description,description,steps) VALUES ('Coconut hot chocolate','Easy tp prepare','Ever tried a boozy "
          +
          " hot chocolate? Whip up this blend of white chocolate,\n coconut rum and fresh coconut flakes and you may never "
          +
          " look back.','STEP 1:\n Pour the milk into a small pan and then place over a medium heat \nuntil simmering, "
          +
          " stirring so it doesn’t scorch.\nRemove the pan from the heat then add the white chocolate \nand stir. " +
          " Once the chocolate has melted, place the pan\n back on the heat to warm through. Add the coconut-flavoured rum and pour "
          +
          " into a mug.\n STEP 2:\nGarnish with the dark chocolate and a\n few toasted coconut flakes if you like.')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO recipes (name,short_description,description,steps) VALUES ('White hot chocolate', 'The best Drink ever', "
          +
          " 'Blend white chocolate with milk and vanilla extract to make this indulgent hot\nchocolate. Add nutmeg, cinnamon or "
          +
          " cardamom for added spiciness, if you like\n','STEP 1:\nPour boiling water from the kettle into a heatproof "
          +
          " mug or glass to\n warm it up. Heat the milk in a small pan, or in blasts\nin the microwave, until steaming. "
          +
          " Pour the hot water out the mug, and tip\nin the chocolate and vanilla. Pour over the hot milk and stir for 30 "
          +
          " seconds\n until the chocolate has melted. Top with the cream, marshmallows and \n drizzle over the sauce with a pinch "
          +
          " of sprinkles and cinnamon, if you like.')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO recipes (name,short_description,description,steps) VALUES ('iced tea', 'Refreshing drink','Make up a jug of "
          +
          " refreshing iced tea to serve on summer days. With a subtle\n flavour, oranges, lemons and mint, it is an excellent alcohol-free "
          +
          " party drink.','STEP 1:\nPut the tea bags, sugar, honey and 1.5 litres water in a large jug. \n Leave to infuse "
          +
          " for 10 mins, then remove and discard the tea bags.\n Chill until ready to serve.\nSTEP 2:\n Stir in the " +
          " lemon juice, lemon slices, orange slices and\n mint leaves. Fill the jug with plenty of ice and stir again.\nSTEP 3:\n Fill "
          +
          " tall glasses with ice and pour over the iced tea, then serve\nwith extra honey to taste. ')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO recipes (name,short_description,description,steps) VALUES ('Pineapple fried rice','A very unique dish','Add chunks of fresh "
          +
          " pineapple to fried rice to transform it into something\n special. Serve on its own for a family dinner " +
          " or as part of a banquet.','STEP 1:\n 1 Heat 1 tbsp oil in a wok. Add the eggs, swirling them up " +
          " the sides,\n to make a thin omelette. Once cooked through,\n roll the omelette onto a chopping board " +
          " and cut into ribbons.\n STEP 2:\nHeat the remaining oil. Add the garlic, onions and five-spice. Stir-fry\n until "
          +
          " sizzling, then add the rice (if using pouches, squeeze them \nfirst, to separate the grains), peas, sesame oil and soy. "
          +
          " Cook over a high\n heat until the rice is hot, then stir through the pineapple and omelette ribbons.')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO recipes (name,short_description,description,steps) VALUES ('Meatball & tomato soup','Easy to prepare','Get three of your 5-a-day "
          +
          " in one serving with this healthy, low-calorie\n tomato soup. The addition of meatballs and giant couscous "
          +
          " means it is filling, too.','STEP 1:\n Heat the oil in a saucepan. Fry the onion and peppers for 7 mins,\n then "
          +
          " stir through the garlic and chilli flakes and cook\n for 1 min. Add the tomatoes, giant couscous and veg stock and "
          +
          " bring to a simmer.\n STEP 2:\n Season to taste, then add the meatballs and spinach. Simmer for\n 5-7 mins or until "
          +
          " cooked through. Ladle into bowls\n and top with the basil and some parmesan, if you like.\n')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO `recipes`( `name`, `short_description`, `description`, `steps`) VALUES ('Baked spaghetti','Easy,cheesy and cozy diner','This super simple comfort food recipe is something your whole family is sure to love!','STEP 1:\n Cook the spaghetti to al dente."
          +
          "\nSTEP 2:\n Make the marinara meat sauce." +
          "\nSTEP 3:\n Add the cooked pasta to the sauce and stir to fully coat the spaghetti." +
          "\nSTEP 4:\n Transfer to a baking dish, sprinkle with cheese, and bake.')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO `recipes`( `name`, `short_description`, `description`, `steps`) VALUES ('Cheeseburger','Juicy and easy burger','This is a great way to make sure you cook a JUICY and PERFECT cheeseburgers each and every time.','STEP 1:\n Take meat and add egg yolk with salt and pepper."
          +
          "\nSTEP 2:\n Mix and shape meat." +
          " \nSTEP 3:\n Place them on frying pan till propertly cooked." +
          " \nSTEP 4:\n Place meat with cheesse between the bun')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO `recipes`( `name`, `short_description`, `description`, `steps`) VALUES ('Pizza margherita','The real intalian pizza','Pizza Margherita is a typical Neapolitan pizza, made with tomatoes, mozzarella cheese.','STEP 1: \nPrepare pizza dough on the baking tray."
          +
          " \nSTEP 2:\n Put souce from tomatoes on pizza and place mozzarella on top of that." +
          " \nSTEP 3:\n Bake 15 minutes in 220C in oven.' )";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO Ingredients (name) VALUES ('Onion')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('garlic cloves')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('chargrilled Mediterranean veg')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('can chopped tomatoes')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('small capers')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('raisins')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('rigatoni')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('basil leaves')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('parmesan')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('apples')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES (' lemon')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('caster sugar')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('eggs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('plain flour')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('baking powder')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('soured cream')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES (' rum')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('butter')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('icing sugar')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO Ingredients (name) VALUES ('red peppers')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('aubergines')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('lasagne sheets')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('olive oil')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('mozzarella')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('cherry tomatoes')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('carrot')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('tomato purée')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('white wine')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('milk')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO Ingredients (name) VALUES ('rapeseed oil')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('chilli flakes')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('giant couscous')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('hot vegetable stock')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('meatballs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('baby spinach')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('vegetable oil')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('Chinese five-spice powder')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('rice')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('peas')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('sesame oil')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('soy sauce')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('pineapple')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('tea bags')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('honey')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('orange')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('mint')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('ice')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO Ingredients (name) VALUES ('white chocolate')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('vanilla')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('squirty cream')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('mini marshmallows')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('caramel sauce')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('sugar sprinkles')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('cinnamon')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('whole milk')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('coconut-flavoured rum')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('dark chocolate')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('coconut flakes')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO Ingredients (name) VALUES ('ketchup')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('spaghetti')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('peanut butter')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('salt')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO Ingredients (name) VALUES (' green grapes')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('blueberries')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('grenadine')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('orange juice')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('sparkling water')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO Ingredients (name) VALUES ('brown pittas')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('halloumi')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('quinoa')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('tomatoes')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('cucumber')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO Ingredients (name) VALUES ('dill')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO `ingredients`( `name`) VALUES ('Spaghetti')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO `ingredients`( `name`) VALUES ('beef')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO `ingredients`( `name`) VALUES ('Marinara souce')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO `ingredients`( `name`) VALUES ('Chedar')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO `ingredients`( `name`) VALUES ('Bun')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO `ingredients`( `name`) VALUES ('Pizza dough')";
      stmt.executeUpdate(sql);
      // stmt.executeUpdate(sql);
      // inserting ingredients for a recipe
      // sql = "INSERT INTO Ingredients (name,amount,unit) VALUES ('Curry',1,'tsp')";
      // stmt.executeUpdate(sql);
      // sql = "INSERT INTO Ingredients (name,amount,unit) VALUES ('red
      // Onion',1,'st')";
      // stmt.executeUpdate(sql);
      // sql = "INSERT INTO Ingredients (name,amount,unit) VALUES
      // ('clovesGarlic',4,'st')";
      // stmt.executeUpdate(sql);
      // sql = "INSERT INTO Ingredients (name,amount,unit) VALUES ('Bell
      // pepper',0.5,'tsp')";
      // stmt.executeUpdate(sql);
      // sql = "INSERT INTO Ingredients (name,amount,unit) VALUES
      // ('Potatoes',4,'st')";
      // stmt.executeUpdate(sql);
      // sql = "INSERT INTO Ingredients (name,amount,unit) VALUES ('ground
      // Turmeric',1,'tsp')";
      // stmt.executeUpdate(sql);
      // sql = "INSERT INTO Ingredients (name,amount,unit) VALUES
      // ('Salt',0.25,'tsp')";
      // stmt.executeUpdate(sql);
      // sql = "INSERT INTO Ingredients (name,amount,unit) VALUES ('Cooking
      // oil',0.20,'ml')";
      // stmt.executeUpdate(sql);

      // + "(RecipeId INTEGER, "
      // + "IngredientId INTEGER, "
      // + " amount FLOAT, "
      // + " unit VARCHAR(255), "
      // + " FOREIGN KEY (RecipeId) REFERENCES recipes(Id), "
      // + " FOREIGN KEY (IngredientId) REFERENCES Ingredients(Id))";

      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (1,1,1,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (1,2,4,'tbsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (1,3,250,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (1,4,400,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (1,5,1,'tbsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (1,6,2,'tbsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (1,7,350,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (1,8,5,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (1,9,100,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (1,23,4,'tbsp ')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (2,10,4,'pcs ')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (2,11,1,'pcs ')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (2,12,440,'g ')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (2,13,4,'pcs ')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (2,14,480,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (2,15,7,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (2,16,250,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (2,17,50,'ml')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (2,18,20,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (2,19,10,'g')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (3,20,3,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (3,21,2,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (3,23,9,'tbsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (3,22,300,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (3,24,125,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (3,25,50,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (3,1,2,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (3,2,2,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (3,26,1,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (3,27,2,'tbsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (3,28,200,'ml')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (3,4,1200,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (3,8,50,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (3,18,85,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (3,14,85,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (3,29,750,'ml')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (4,68,2,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (4,23,5,'tbsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (4,11,2,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (4,2,1,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (4,69,250,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (4,70,250,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (4,71,350,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (4,72,1,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (4,1,4,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (4,46,25,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (4,73,3,'pcs')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (5,63,50,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (5,64,50,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (5,65,4,'tbsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (5,66,400,'ml')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (5,67,50,'ml')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (6,61,200,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (6,12,175,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (6,62,1,'tsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (6,13,1,'pcs')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (7,30,1,'tbsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (7,34,300,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (7,8,3,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (7,1,1,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (7,2,3,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (7,59,1,'tbsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (7,4,800,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (7,60,225,'g')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (8,56,150,'ml')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (8,48,25,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (8,56,25,'ml')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (8,57,1,'tsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (8,58,1,'tsp')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (9,29,200,'ml')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (9,48,100,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (9,49,1,'tsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (9,50,1,'tbsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (9,51,50,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (9,52,1,'tsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (9,53,20,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (9,54,2,'tsp')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (10,43,6,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (10,12,2,'tbsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (10,44,1,'tbsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (10,11,2,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (10,45,1,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (10,46,60,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (10,47,200,'g')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (11,36,2,'tbsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (11,13,2,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (11,2,2,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (11,1,50,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (11,37,1,'tsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (11,38,400,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (11,39,85,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (11,40,2,'tsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (11,41,2,'tbsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (11,42,400,'g')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (12,30,2,'tbsp')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (12,1,1,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (12,2,1,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (12,31,1,'tsp ')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (12,4,800,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (12,32,100,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (12,33,500,'ml')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (12,34,12,'pcs')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (12,35,150,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (12,8,50,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (12,9,100,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO RecipeIngredients (RecipeId,IngredientId,amount,unit) VALUES (12,20,2,'pcs')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO `recipeingredients`(`RecipeId`, `IngredientId`, `amount`, `unit`) VALUES (13,24,500,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO `recipeingredients`(`RecipeId`, `IngredientId`, `amount`, `unit`) VALUES (13,74,450,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO `recipeingredients`(`RecipeId`, `IngredientId`, `amount`, `unit`) VALUES (13,75,450,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO `recipeingredients`(`RecipeId`, `IngredientId`, `amount`, `unit`) VALUES (13,76,700,'g')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO `recipeingredients`(`RecipeId`, `IngredientId`, `amount`, `unit`) VALUES (14,75,450,'g')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO `recipeingredients`(`RecipeId`, `IngredientId`, `amount`, `unit`) VALUES (14,13,1,'psc')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO `recipeingredients`(`RecipeId`, `IngredientId`, `amount`, `unit`) VALUES (14,77,1,'psc')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO `recipeingredients`(`RecipeId`, `IngredientId`, `amount`, `unit`) VALUES (14,78,1,'psc')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO `recipeingredients`(`RecipeId`, `IngredientId`, `amount`, `unit`) VALUES (15,79,1,'psc')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO `recipeingredients`(`RecipeId`, `IngredientId`, `amount`, `unit`) VALUES (15,4,1,'psc')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO `recipeingredients`(`RecipeId`, `IngredientId`, `amount`, `unit`) VALUES (15,24,500,'g')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO tags (Id,Name) VALUES (1,'vegetarian')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tags (Id,Name) VALUES (2,'sweets')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tags (Id,Name) VALUES (3,'dessert')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tags (Id,Name) VALUES (4,'vegean')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tags (Id,Name) VALUES (5,'gluten free')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tags (Id,Name) VALUES (6,'main course')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tags (Id,Name) VALUES (7,'starter')";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tags (Id,Name) VALUES (8,'lactose free')";
      stmt.executeUpdate(sql);

      sql = "INSERT INTO tagsrecipe (Recipe_id,Id) VALUES (1,1)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tagsrecipe (Recipe_id,Id) VALUES (2,2)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tagsrecipe (Recipe_id,Id) VALUES (2,3)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tagsrecipe (Recipe_id,Id) VALUES (3,1)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tagsrecipe (Recipe_id,Id) VALUES (4,1)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tagsrecipe (Recipe_id,Id) VALUES (5,1)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tagsrecipe (Recipe_id,Id) VALUES (5,4)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tagsrecipe (Recipe_id,Id) VALUES (5,5)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tagsrecipe (Recipe_id,Id) VALUES (6,5)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tagsrecipe (Recipe_id,Id) VALUES (7,6)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tagsrecipe (Recipe_id,Id) VALUES (8,2)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tagsrecipe (Recipe_id,Id) VALUES (9,2)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tagsrecipe (Recipe_id,Id) VALUES (10,1)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tagsrecipe (Recipe_id,Id) VALUES (10,5)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tagsrecipe (Recipe_id,Id) VALUES (11,1)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO tagsrecipe (Recipe_id,Id) VALUES (12,7)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO `tagsrecipe`(`Recipe_id`, `Id`) VALUES (13,6)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO `tagsrecipe`(`Recipe_id`, `Id`) VALUES (14,6)";
      stmt.executeUpdate(sql);
      sql = "INSERT INTO `tagsrecipe`(`Recipe_id`, `Id`) VALUES (15,6)";
      stmt.executeUpdate(sql);

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
