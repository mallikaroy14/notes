db.createCollection('restaurants');

db.restaurants.insert([
{"address":{
    "building":"1007",
    "coord":[-73.856077, 40.848447 ],
     "street": "Morris Park Ave",
     "zipcode": "10462"
},
"borough":"Bronx",
"cuisine": "Bakery",
"grades": [
    {"date":{"$date":1393804800000}, "grade":"A", "score":2},
    { "date": { "$date": 1378857600000 }, "grade": "A", "score": 6 },
    { "date": { "$date": 1358985600000 }, "grade": "A", "score": 10 },
    { "date": { "$date": 1322006400000 }, "grade": "A", "score": 9 },
    { "date": { "$date": 1299715200000 }, "grade": "B", "score": 14 }
],
"name":"Morris Park Bake Shop",
"restaurant_id":"30075445"
}
])


1. show all data 
db.restaurants.find();

2.Write a MongoDB query to display the fields restaurant_id, name, borough and cuisine
 for all the documents in the collection restaurant.

 db.restaurants.find({},
   {restaurant_id:1,
    name:1,
    borough:1,
    cuisine:1
    });


3. Write a MongoDB query to display the fields restaurant_id, name, borough and cuisine, 
but exclude the field _id for all the documents in the collection restaurant.

 db.restaurants.find({},
   {restaurant_id:1,
    name:1,
    borough:1,
    cuisine:1,
    _id:0
    });
    
4.  Write a MongoDB query to display the fields restaurant_id, name, borough and zip code,
 but exclude the field _id for all the documents in the collection restaurant.  

 db.restaurants.find({},{
    restaurant_id:1,
    name:1,
    borough:1,
   "address.zipcode":1,
    _id:0
 }) 

 5.  Write a MongoDB query to display all the restaurant which is in the borough Bronx.

 db.restaurants.find(
 {"borough":{$eq:"Bronx"}});
-- db.restaurants.find({"borough": "Bronx"})

 6. Write a MongoDB query to display the first 5 restaurant which is in the borough Bronx.
 db.restaurants.find({"borough":"Bronx"}).limit(5)

Write a MongoDB query to display the next 5 restaurants after
 skipping first 5 which are in the borough Bronx.
 db.restaurants.find({"borough":"Bronx"}).limit(5).skip(5);

 8. Write a MongoDB query to find the restaurants who achieved a score more than 90.
// db.restaurants.find({
//     "grades.score":{$gt:90}
// })

db.restaurants.find({
    grades:{$elemMatch:{"score":{$gt:90}}}
})

9. Write a MongoDB query to find the restaurants that
 achieved a score, more than 80 but less than 100.

//  db.restaurants.find({
//     "grades.score":{$gt:80,$lt:100}
//  })

 db.restaurants.find({
   grades:{$elemMatch:{"score":{$gt:80,$lt:100}}}
 })

 10. Write a MongoDB query to find the restaurants
  which locate in latitude value less than -95.754168.

db.restaurants.find({
    address:{
        elemMatch:{"coord":[{$lt:-95.754168}]}
    }
})

db.restaurants.find({
    "address.coord":{$lt:-95.754168}
})


11.Write a MongoDB query to find the restaurants that do not prepare any 
cuisine of 'American' and their grade score more than 70 and latitude less than -65.754168.

db.restaurants.find(
    {$and:
       [
        {"cuisine" : {$ne :"American "}},
          {"grades.score": {$gt : 70}},
          {"address.coord": {$lt : -65.754168}}
        ]
});

12. Write a MongoDB query to find the restaurants which do not prepare any cuisine of 
'American' and achieved a score more than 70 and located in the longitude less than -65.754168.
Note : Do this query without using $and operator.

db.restaurants.find({ 
"cuisine": {$ne: "American"},
"grades.score":{$gt:70},
"address.coord":{$lt:-65.754168}
});

13. Write a MongoDB query to find the restaurants which do not prepare any cuisine
 of 'American' and achieved a grade point 'A' not belongs to the borough Brooklyn. 
 The document must be displayed according to the cuisine in descending order.

 db.restaurants.find({
    "cuisine": {$ne: "American"},
    "grades.grade": {$eq: "A"},
    "borough": {$ne: "Brooklyn"}
 }).sort({cuisine:-1})

14.  Write a MongoDB query to find the restaurant Id, name, borough and cuisine for 
  those restaurants which contain 'Wil' as first three letters for its name.

  db.restaurants.find(
    {
       name: /^Wil/
    },
    {"restaurant_id": 1, "name": 1, "borough": 1, "cuisine":1}
  )

  15. Write a MongoDB query to find the restaurant Id, name, borough and cuisine for 
  those restaurants which contain 'ces' as last three letters for its name.

db.restaurants.find(
    {
        name:/ces$/
    },
     {"restaurant_id": 1, "name": 1, "borough": 1, "cuisine":1}
)

16. Write a MongoDB query to find the restaurant Id, name, borough and cuisine for
 those restaurants which contain 'Reg' as three letters somewhere in its name.

 db.restaurants.find(
    {
        name:/Reg/
    },
     {"restaurant_id": 1, "name": 1, "borough": 1, "cuisine":1}
)

or db.restaurants.find(
{"name": /.*Reg.*/},
{
"restaurant_id" : 1,
"name":1,"borough":1,
"cuisine" :1
}
);

17. Write a MongoDB query to find the restaurants 
which belong to the borough Bronx and prepared either American or Chinese dish.

db.restaurants.find({
  $and:[{"borough":"Bronx"},
   {$or:[
       { cuisine : "Chinese"},
       { cuisine : "American"}
        ]}
  ]
});

db.restaurants.find({
"borough":"Bronx",
   $or:[
       { cuisine : "Chinese"},
       { cuisine : "American"}
        ]
});

18. Write a MongoDB query to find the restaurant Id, name, borough and cuisine for those 
restaurants which belong to the borough Staten Island or Queens or Bronxor Brooklyn.

db.restaurants.find({
 borough:{ $in:["Staten Island","Queens","Bronxor"]}
},{
restaurant_id :1, name:1, borough:1, cuisine:1
})

19. Write a MongoDB query to find the restaurant Id, name, borough and cuisine for those
 restaurants which are not belonging to the borough Staten Island or Queens or Bronxor Brooklyn.

db.restaurants.find({
  borough:{$nin:["Staten Island","Queens","Bronxor"]}
},{
  restaurant_id :1, name:1, borough:1, cuisine:1
})

20. Write a MongoDB query to find the restaurant Id, name, borough and cuisine for those restaurants
 which achieved a score which is not more than 10.


db.restaurants.find({
  "grades.score" :{$not: {$gt:10}}
},{
  restaurant_id :1, name:1, borough:1, cuisine:1
})

//21. Write a MongoDB query to find the restaurant Id, name, borough and cuisine for those restaurants
//which prepared dish except 'American' and 'Chinees' or restaurant's name begins with letter 'Wil'.

db.restaurants.find({
  $or:[{"name":/^Will/},{
 $and:[
    {cuisine: {$ne:"American"}},
     {cuisine: {$ne:"Chinees"}},
  ]}]
},{
  restaurant_id :1, name:1, borough:1, cuisine:1
});

22.  Write a MongoDB query to find the restaurant Id, name, and grades for those restaurants which
achieved a grade of "A" and scored 11 on an ISODate "2014-08-11T00:00:00Z" among many of survey dates..

db.restaurants.find({
 "grades.grade":"A",
 "grades.score":11,
 "grades.date":ISODate("2014-08-11T00:00:00Z")
},{
  restaurant_id :1, name:1, grades:1
});

23. Write a MongoDB query to find the restaurant Id, name and grades for those restaurants where the
2nd element of grades array contains a grade of "A" and score 9 on an ISODate "2014-08-11T00:00:00Z".

db.restaurants.find({
  "grades.1.grade":"A",
  "grades.1.score":9,
  "grades.1.date":ISODate("2014-08-11T00:00:00Z")
},
{
  restaurant_id :1, name:1, grades:1
});


24.Write a MongoDB query to find the restaurant Id, name, address and geographical location for those
 restaurants where 2nd element of coord array contains a value which is more than 42 and upto 52..


db.restaurants.find({
    "address.coord.1":{$gt:42, $lte:52}
    },
    {restaurant_id:1, name:1, address:1, coord:1}
    );


25. Write a MongoDB query to arrange the name of the restaurants in ascending order along with all the columns.

db.restaurants.find().sort("name")

26. Write a MongoDB query to arrange the name of the restaurants in descending along with all the columns.
db.restaurants.find().sort({"name":-1})

27. Write a MongoDB query to arranged the name of the cuisine in ascending order and for that same cuisine borough 
should be in descending order.

db.restaurants.find().sort(
 {
 "cuisine": 1, "borough": -1}
);


db.restaurants.aggregate([
  {
    $sort:{"cuisine":1}
  },
  {
    $sort:{"borough":-1}
  }
])

28. Write a MongoDB query to know whether all the addresses contains the street or not.

db.restaurants.find(
  {"address.street":{$exists:true}} 
)

29. Write a MongoDB query which will select all documents in the restaurants collection where the coord field
 value is Double.

db.restaurants.find(
  {
    "address.coord":{$type:1}
  }
)

30.  Write a MongoDB query which will select the restaurant Id, name and grades for those restaurants which
 returns 0 as a remainder after dividing the score by 7.

db.restaurants.find(
  {
  "grades.score": {$mod:[7,0]}
},
   {restaurant_id:1, name:1,grades:1}
)

31. Write a MongoDB query to find the restaurant name, borough, longitude and lattitude and cuisine 
for those restaurants which contains 'mon' as three letters somewhere in its name.

db.restaurants.find(
  {
    name: { $regex : "mon.*", $options: "i" }
  },{
    name:1,borough:1,longitude:1,lattitude:1, cuisine :1
  }
)
32. Write a MongoDB query to find the restaurant name, borough, longitude and latitude and cuisine for those 
restaurants which contain 'Mad' as first three letters of its name.


33. Write a MongoDB query to find the restaurants that have at least one grade with a score of less than 5.

34. Write a MongoDB query to find the restaurants that have at least one grade with a score of less than 5 and 
that are located in the borough of Manhattan.

35. Write a MongoDB query to find the restaurants that have at least one grade with a score of less than 5 
and that are located in the borough of Manhattan or Brooklyn.



48. Write a MongoDB query to find the restaurants that have all grades with a score greater than 5.

51. Write a MongoDB query to find the average score for each restaurant.

db.restaurants.aggregate([
  {
 $unwind: "$grades"
  },
  {$group:{_id:"$name", "avg_score":{$avg:"$grades.score"}}
  }
])

52.Write a MongoDB query to find the highest score for each restaurant.

db.restaurants.aggregate([
  {
    $unwind:"$grades"
  },
  {
    $group:{_id:"$name","highest_score":{
      $max: "$grades.score"
    }}
  }
])


53. Write a MongoDB query to find the lowest score for each restaurant.

db.restaurants.aggregate([
  {
    $unwind:"$grades"
  },
  {
    $group:{_id:"$name","highest_score":{
      $min: "$grades.score"
    }}
  }
])

54. Write a MongoDB query to find the count of restaurants in each borough.

db.restaurants.aggregate([
  {
    $group:{_id:"$borough", "count":{$sum:1}}
  }
])

55. Write a MongoDB query to find the count of restaurants for each cuisine.

db.restaurants.aggregate([
  {
    $group:{_id:"$cuisine", "count":{$sum:1}}
  }
])

56. Write a MongoDB query to find the count of restaurants for each cuisine and borough.

db.restaurants.aggregate([
  {
    $group:{
      _id:{
        cuisine:"$cuisine",
        borough:"$borough"
      }, 
      "count":{$sum:1}}
  }
])

57. Write a MongoDB query to find the count of restaurants that received a grade of 'A'
 for each cuisine.

db.restaurants.aggregate([
  {
    $unwind: "$grades"
  },
  {
    $match:{"grades.grade":"A"}
  },
  {
    $group: {
      _id:"$cuisine", 
      count: { $sum: 1 }
    }
  }
])

58. Write a MongoDB query to find the count of restaurants that received a grade of 'A' 
for each borough.

db.restaurants.aggregate([
  {
    $unwind: "$grades"
  },
  {
    $match:{"grades.grade":"A"}
  },
  {
    $group: {
      _id:"$borough", 
      count: { $sum: 1 }
    }
  }
])

59. Write a MongoDB query to find the count of restaurants that received a 
grade of 'A' for each cuisine and borough.

db.restaurants.aggregate([
  {
    $unwind: "$grades"
  },
  {
    $match:{"grades.grade":"A"}
  },
  {
    $group: {
      _id:{
          borough:"$borough",
          cuisine:"$cuisine"
      }, 
      count: { $sum: 1 }
    }
  },
  {
    $sort:{count : -1}
  }
])

61. Write a MongoDB query to find the average score for each cuisine.

db.restaurants.aggregate([
  {
    $unwind: "$grades"
  },
  {
    $group:{
       _id: "$cuisine", "avg_score":{$avg: "$grades.score"}
    }
  }
])

62. Write a MongoDB query to find the highest score for each cuisine.

db.restaurants.aggregate([
  {
    $unwind: "$grades"
  },
  {
    $group:{
       _id: "$cuisine", "avg_score":{$max: "$grades.score"}
    }
  }
])

64. Write a MongoDB query to find the average score for each borough.
db.restaurants.aggregate([
  {
    $unwind: "$grades"
  },
  {
    $group:{
      _id:"$borough", "avg_value":{$avg:"$grades.score"}
    }
  }
])


67. Write a MongoDB query to find the name and address of the restaurants that
 received a grade of 'A' on a specific date.

db.restaurants.find(
{
"grades":{
  "$elemMatch":{
    "date": {
      "$eq": ISODate("2013-07-22T00:00:00Z")
     },
     "grade": {
     "$eq" : "A"
     }
    }
  }
},
{"name":1,"address":1, "_id":0}
 );

 68. Write a MongoDB query to find the name and address of the restaurants that received a grade of 'B'
  or 'C' on a specific date.

db.restaurants.find(
  {
    "grades":{
      "$elemMatch":{
        "date":{
          "$eq": ISODate("2013-07-22T00:00:00Z")
        },
        "grade": {
          "$in":["A","C"]
        }
      }
    }
  }
)

69. Write a MongoDB query to find the name and address of the restaurants that have at least one 'A' grade
and one 'B' grade.

db.restaurants.find(
  {
    $and:[
      {"grades.grade":"A"},
      {"grades.grade":"B"}
    ]
  },{
    "name":1, address:1, _id:0
  }
)

70. Write a MongoDB query to find the name and address of the restaurants that have at least one 'A' 
grade and no 'B' grades.

db.restaurants.find(
  {
    $and:[
      {"grades.grade":"A"},
      {"grades.grade": {$not :{$eq:"B"}}}
    ]
  },
  {
    "name":1, address:1, _id:0
  }
)


71. Write a MongoDB query to find the name ,address and grades of the restaurants that have at least
 one 'A' grade and no 'C' grades.


db.restaurants.find(
  {
    $and:[
      {"grades.grade":"A"},
      {"grades.grade": {$not :{$eq:"C"}}}
    ]
  },
  {
    "name":1, address:1, _id:0,"grades.grade":1
  }
) 

72. Write a MongoDB query to find the name, address, and grades of the restaurants that have at least 
one 'A' grade, no 'B' grades, and no 'C' grades.

db.restaurants.find(
  {
    $and:[
      {"grades.grade":"A"},
      {"grades.grade":{$not:{$eq:"B"}}},
      {"grades.grade":{$not:{$eq:"C"}}}
    ]
  }
)

73. Write a MongoDB query to find the name and address of the restaurants that have the
 word 'coffee' in their name.


db.restaurants.find(
  {
    name:{ $regex: /coffee/i}
  },
  {
    name:1, address:1
  }
  )


74. Write a MongoDB query to find the name and address of the restaurants that have a zipcode
 that starts with '10'.

db.restaurants.aggregate([
  {
    $unwind:"$address"
  },
   {
    $match:{"address.zipcode" :{$regex: /^10/}}
  },
  {
   $project: { name:1, "address.street":1,_id:0, "address.zipcode":1}
  }
 ] 
)

75. Write a MongoDB query to find the name and address of the restaurants that have a cuisine that
 starts with the letter 'B'.

db.restaurants.aggregate([
  {
     $match:{"cuisine": /^B/}
  },
  {
    $project:{name:1, address:1,cuisine:1}
  }
])

76. Write a MongoDB query to find the name, address, and cuisine of the restaurants that have a cuisine
 that ends with the letter 'y'.

db.restaurants.aggregate([
  {
     $match:{"cuisine": {$regex: /y$/i}}
  },
  {
    $project:{name:1, address:1,cuisine:1}
  }
])

77. Write a MongoDB query to find the name, address, and cuisine of the restaurants that have a cuisine 
that contains the word 'Pizza'.

db.restaurants.aggregate([
  {
     $match:{"cuisine": {$regex: /.*Pizza.*/i}}
  },
  {
    $project:{name:1, address:1,cuisine:1}
  }
])

78. Write a MongoDB query to find the restaurants achieved highest average score.

db.restaurants.aggregate([
  {
    $unwind:"$grades"
  },
  {
    $group:{_id:"$restaurant_id","avg_score": {$avg:"$grades.score"}}
  },
  {
    $sort:{avg_score: -1}
  },
  {
    $limit:1
  }
])

79. Write a MongoDB query to find all the restaurants with the highest number of "A" grades.

db.restaurants.aggregate([
  {
    $unwind:"$grades"
  },
  {
    $match:{"grades.grade":"A"}
  },
  {
    $group:{_id:"$restaurant_id", "noOfA":{$sum:1}}
  },
  {
    $sort:{noOfA:-1}
  },
  {
    $group:{_id:"$noOfA", restaurant: {$push: "$_id"}}
  },
  {
    $sort: {_id:-1}
    },
    {
      $limit:1
    }

])


80. Write a MongoDB query to find the cuisine type that is most likely to receive a "C" grade.

db.restaurants.aggregate([
  {$unwind:"$grades"},
  {
    $match:{"grades.grade":"C"}
  },
  {
    $group:{_id:"$cuisine", "countOfCuisine":{$sum:1}}
  },{
    $sort:{"countOfCuisine":-1}
  }
])

81. Write a MongoDB query to find the restaurant that has the highest average score for the cuisine "Turkish".

db.restaurants.aggregate([
  {
    $unwind:"$grades"
  },
  {
    $match:{"cuisine":"Turkish"}
  },
  {
    $group:{_id:"$name","avgScore":{$avg:"$grades.score"}}
  },
  {
    $sort:{"avgScore":-1}
  }
])

82. Write a MongoDB query to find the restaurants that achieved the highest total score.


db.restaurants.aggregate([
  {
    $unwind:"$grades"
  },
  {
    $group:{_id:"$name","highestScore":{$sum:"$grades.score"}}
  },
  {
    $sort:{"highestScore":-1}
  },
  {
    $limit:1
  }
])


83. Write a MongoDB query to find all the Chinese restaurants in Brooklyn.

db.restaurants.find(
  {
    $and:[{
       "cuisine": "Chinese",
    },{
      "borough":"Brooklyn"
    }]

})

84. Write a MongoDB query to find the restaurant with the most recent grade date.

db.restaurants.aggregate([
  {
    $unwind: "$grades"
  },
  {
    $sort: {"grades.date":-1 }
  },
  {
    $limit:1
  },
  {
    $project: {name:1, "grades.date":1}
  }
])


85. Write a MongoDB query to find the top 5 restaurants with the highest average score for each 
cuisine type, along with their average scores.

db.restaurants.aggregate([
  {
    $unwind:"$grades"
  },
  {
    $group:{_id:"$name", "avgScore":{$avg:"$grades.score"}}
  },
  {
    $sort: {"avgScore":-1}
  },{
    $limit:5
  }
])

db.restaurants.aggregate([
  {
    $unwind:"$grades"
  },{
    $group:{_id:{
  cuisine: "$cuisine", restaurant_id:"$restaurant_id",
  "avgScore":{$avg:"$grades.score"}}}
  },{
    $sort: {"avgScore":-1}
  }
])


86. Write a MongoDB query to find the top 5 restaurants in each borough with
 the highest number of "A" grades.

 db.restaurants.aggregate([
  {
    $unwind:"$grades"
  },
  {
   $match:{"grades.grade":"A"} 
  },{
    $group:{_id:{
        borough: "$borough", restaurant_id:"$restaurant_id"},"gradeCount":{$sum:1} 
    }
  },{
    $sort:{
      "_id.borough":1, gradeCount:-1
    }
  },{
    $group:{_id:"_id.borough", 
    topRestaurants:{$push:{restaurant_id:"$_id.restaurant_id",
    gradeCount: "$gradeCount"
    }}}
  },
  {$project: {
    _id: 0,
    borough: "$_id",
    topRestaurants: {$slice: ["$topRestaurants", 5]}
  }}
 ])

87. Write a MongoDB query to find the borough with the highest number of restaurants
 that have a grade of "A" and a score greater than or equal to 90.


 db.restaurants.aggregate([
  {
   $match:{
      "grades.grade":"A",
      "grades.score":{$gte:90}
  }
  },{
    $group:{_id: "$borough","gradeCount":{$sum:1} 
    }
  },{
    $sort:{ gradeCount:-1
    }
  },{
    $limit:1
  }
 ])



 db.products.updateMany({},{$set:{name:"Mallika","age":12}})

//Increament

db.collectionName.updateOne({},{$set:{name:{$inc:val}}})

db.users.find({vendor:{$nin["Vinn","AAkash"]}})

db.users.find().count()
db.users.find().limit(2)
db.users.find().skip(2)
db.users.find().

gender:{
 bsonType:"string"
 enum:["Male","Female","Other"]


}

  
  $group:{_id:"$city","count":{$sum:1},"people":{$push:{name:"$name",age:"$age"}}}


"people":{$push:"$$ROOT"}
  $group:{_id:"$city","count":{$sum:1}, "names":{$push:"$name"}}

 $match:{employees:{$gt:{$size:0}}}

 $match:{
  employees;{gt{$size:0}}
 }


db.users.updateOne({name:"Saurabh"},{$set:{age:28,city:"Mumbai",gender:"Male",email:"saurabh@gmail.com",hobbies:["Cricket"]}},{upsert:true})
db.users.updateOne({name:"Mallika"},{upsert:true})

