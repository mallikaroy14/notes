
show collections;

db.products.insert([

{name:"Samsung M51", price:34000,quantity:120,category:["Mobile","Electronins"]},
{name:"water bottel", price:400,quantity:10,category:["Home","Appliance"]},
{name:"Plate", price:4300,quantity:420,category:["Culinary","Home"]},
{name:"Plate", price:4300,quantity:420,category:["Culinary","Home"]},
])

db.products.updateMany({},{$set:{mainCategory:"Mobile",vendor:"Vinayak"}})


db.products.find();
db.products.updateOne({prop:val},{$set:{prop:newValue,.....}})

db.products.updateOne({_id: ObjectId('65b1e45a3551778f57287e1a')},{$set:{mainCategory:"Electronins"}})


db.products.updateOne({_id: ObjectId('65b1e4073551778f57287e19')},{$set:{mainCategory:""}})


db.products.updateOne({},{$set:{mainCategory:"Mobile",vendor:"Akash"}})


db.products.find({vendor:{$in:["Vinayak","Akash"]}})

db.products.findManny

//Query operators

-- $eq: equal
db.products.find({quantity:{$eq:120}}) : Equal
db.products.find({quantity:{$ne:120}}) : Not equal

db.products.find({price:{$lt:1000}}) : lest than
db.products.find({price:{$gt:2200}}) : greater than

db.products.find({quantity:{$gte:420}}): greater than and equal


\\logical operators
db.products.find({price:{$lt:1000},quantity:{$gt:100}})

db.products.find({$and:[{price:{$lt:1000}},{quantity:{$lt:100}}]})


db.products.find({$or:[{price:{$lt:1000}},{quantity:{$gt:100}}]})


db.createCollection('users');

db.users.insert([
    {name:"mallika",
    age:23,
    city:"",
    hobbies:["volleyball","Cricket"],
    email:"mallika@gmail.com",
    gender:"Female"},

    {name:"Rosy",
    age:21,
    city:"",
    hobbies:["cycling","gardening"],
    email:"rosy@gmail.com",
    gender:"Female"},

    {name:"Rahul",
    age:25,
    city:"ranch",
    hobbies:["Study","Invest"],
    email:"rahul@gmail.com",
    gender:"Male"},

    {name:"Renu",
    age:40,
    city:"Darbhanga",
    hobbies:["Teaching","Traveling"],
    email:"renu@gmail.com",
    gender:"Female"},
]);


db.users.insert([
    {name:"Ram",
    age:43,
    city:"Ayodhya",
    hobbies:["Archies","Travelling"],
    email:"ram@gmail.com",
    gender:"Male"},
    ]);

db.users.find();

fetch 

db.users.find({hobbies:"Cricket"});
db.users.find({
    $or:[
    {city:"Darbhanga"},
    {age:{$gt:30}}
]
});

db.users.find({gender:{$eq:'Male'}});

db.users.find({
    city: 'Ayodhya'
},{name:1,hobbies:1});

db.users.find({city:{$nin:["Ayodhya","Darbhanga"]}},{name:1,city:1});


//json scheme validator

--  minLength, maxLength for String
--  minimum for Number
--  maxItems for arrray

db.createCollection('users',{
    validator:{
        $jsonSchema:{
            type:"object",
            required:["name","age","city","email","hobbies","gender"],
            properties:{
                name:{
                    type:"string",
                    description:"name field",
                    maxLength:20
                },
                age:{
                    type:"number",
                    description:"Age field",
                    minimum:12,
                    maximum:100
                },
                city:{
                    type:"string",
                    description:"City field"
                },
                hobbies:{
                    type:"array",
                    minItems:1,
                    maxItems:4,
                    items:{
                        type:"string"
                    }
                },
                email:{
                    type:"string",
                    pattern:"[a-z0-9._%+\-]+@[a-z0-9.\-]+\.[a-z]{2,}$"
                },
                gender:{
                    type:"string",
                    enum:["Male","Female","other"]
                }
            }
        }
    }
})


db.users.insert({name:"Mallika","age":27,"hobbies":["cricket","volleyball"],"email":"mallika@gmail.com","gender":"Female","city":"pune"})


db.users.insertMany([
    {name:"Rosy","age":22,"hobbies":["painting","gardening"],"email":"rosy@gmail.com","gender":"Female","city":"darbhanga"},
    {name:"Nagy","age":25,"hobbies":["sports","travelling"],"email":"nagy@gmail.com","gender":"Female","city":"mumbai"},
    {name:"Ruby","age":27,"hobbies":["painting","cooking"],"email":"nagy@gmail.com","gender":"Male","city":"pune"},
    {name:"Priti","age":30,"hobbies":["shopping","reading"],"email":"priti@gmail.com","gender":"Female","city":"texas"},
    {name:"Deepak","age":30,"hobbies":["reading","travelling"],"email":"deepak@gmail.com","gender":"Male","city":"delhi"},
    {name:"Renu","age":40,"hobbies":["travelling","gardening"],"email":"rennu@gmail.com","gender":"Female","city":"darbhanga"} 
    ]);

    db.users.insertMany([
    {
      "name": "John Doe",
      "age": 25,
      "city": "New York",
      "hobbies": ["Reading", "Hiking"],
      "email": "john.doe@email.com",
      "gender": "Male"
    },
    {
      "name": "Jane Smith",
      "age": 30,
      "city": "Los Angeles",
      "hobbies": ["Swimming", "Painting"],
      "email": "jane.smith@email.com",
      "gender": "Female"
    },
    {
      "name": "Michael Johnson",
      "age": 28,
      "city": "Chicago",
      "hobbies": ["Running", "Photography"],
      "email": "michael.johnson@email.com",
      "gender": "Male"
    },
    {
      "name": "Emily Davis",
      "age": 22,
      "city": "Houston",
      "hobbies": ["Dancing", "Traveling"],
      "email": "emily.davis@email.com",
      "gender": "Female"
    },
    {
      "name": "William Wilson",
      "age": 35,
      "city": "San Francisco",
      "hobbies": ["Gaming", "Cooking"],
      "email": "william.wilson@email.com",
      "gender": "Male"
    },
    {
      "name": "Olivia Martinez",
      "age": 27,
      "city": "Miami",
      "hobbies": ["Singing", "Yoga"],
      "email": "olivia.martinez@email.com",
      "gender": "Female"
    },
    {
      "name": "Daniel Brown",
      "age": 31,
      "city": "Houston",
      "hobbies": ["Cycling", "Reading"],
      "email": "daniel.brown@email.com",
      "gender": "Male"
    },
    {
      "name": "Sophia Anderson",
      "age": 29,
      "city": "Dallas",
      "hobbies": ["Painting", "Hiking"],
      "email": "sophia.anderson@email.com",
      "gender": "Female"
    },
    {
      "name": "Matthew Taylor",
      "age": 26,
      "city": "San Francisco",
      "hobbies": ["Gardening", "Writing"],
      "email": "matthew.taylor@email.com",
      "gender": "Male"
    },
    {
      "name": "Ava Garcia",
      "age": 33,
      "city": "Miami",
      "hobbies": ["Cooking", "Running"],
      "email": "ava.garcia@email.com",
      "gender": "Female"
    },
    {
      "name": "Christopher Moore",
      "age": 24,
      "city": "Dallas",
      "hobbies": ["Traveling", "Photography"],
      "email": "christopher.moore@email.com",
      "gender": "Male"
    },
    {
      "name": "Isabella Rodriguez",
      "age": 32,
      "city": "San Francisco",
      "hobbies": ["Yoga", "Singing"],
      "email": "isabella.rodriguez@email.com",
      "gender": "Female"
    },
    {
      "name": "Andrew Wilson",
      "age": 28,
      "city": "Houston",
      "hobbies": ["Reading", "Cycling"],
      "email": "andrew.wilson@email.com",
      "gender": "Male"
    },
    {
      "name": "Mia Lee",
      "age": 23,
      "city": "Miami",
      "hobbies": ["Hiking", "Dancing"],
      "email": "mia.lee@email.com",
      "gender": "Female"
    },
    {
      "name": "Ethan Hernandez",
      "age": 29,
      "city": "San Francisco",
      "hobbies": ["Writing", "Gaming"],
      "email": "ethan.hernandez@email.com",
      "gender": "Male"
    },
    {
      "name": "Chloe Smith",
      "age": 27,
      "city": "Dallas",
      "hobbies": ["Photography", "Swimming"],
      "email": "chloe.smith@email.com",
      "gender": "Female"
    },
    {
      "name": "Jacob Johnson",
      "age": 34,
      "city": "Chicago",
      "hobbies": ["Running", "Reading"],
      "email": "jacob.johnson@email.com",
      "gender": "Male"
    },
    {
      "name": "Grace White",
      "age": 26,
      "city": "San Francisco",
      "hobbies": ["Cooking", "Gardening"],
      "email": "grace.white@email.com",
      "gender": "Female"
    },
    {
      "name": "Ryan Miller",
      "age": 30,
      "city": "Miami",
      "hobbies": ["Dancing", "Traveling"],
      "email": "ryan.miller@email.com",
      "gender": "Male"
    },
    {
      "name": "Lily Davis",
      "age": 25,
      "city": "New York",
      "hobbies": ["Singing", "Yoga"],
      "email": "lily.davis@email.com",
      "gender": "Female"
    },
    {
      "name": "Noah Martinez",
      "age": 28,
      "city": "Houston",
      "hobbies": ["Cycling", "Painting"],
      "email": "noah.martinez@email.com",
      "gender": "Male"
    },
    {
      "name": "Ella Robinson",
      "age": 31,
      "city": "Dallas",
      "hobbies": ["Reading", "Swimming"],
      "email": "ella.robinson@email.com",
      "gender": "Female"
    },
    {
      "name": "Alexander Thompson",
      "age": 29,
      "city": "San Francisco",
      "hobbies": ["Gaming", "Hiking"],
      "email": "alexander.thompson@email.com",
      "gender": "Male"
    },
    {
      "name": "Aria Harris",
      "age": 33,
      "city": "Miami",
      "hobbies": ["Writing", "Photography"],
      "email": "aria.harris@email.com",
      "gender": "Female"
    },
    {
      "name": "Logan Allen",
      "age": 27,
      "city": "Chicago",
      "hobbies": ["Running", "Cooking"],
      "email": "logan.allen@email.com",
      "gender": "Male"
    },
    {
      "name": "Sofia Wright",
      "age": 24,
      "city": "New York",
      "hobbies": ["Traveling", "Dancing"],
      "email": "sofia.wright@email.com",
      "gender": "Female"
    },
    {
      "name": "James Hall",
      "age": 32,
      "city": "Houston",
      "hobbies": ["Yoga", "Reading"],
      "email": "james.hall@email.com",
      "gender": "Male"
    },
    {
      "name": "Avery Foster",
      "age": 28,
      "city": "Dallas",
      "hobbies": ["Painting", "Gaming"],
      "email": "avery.foster@email.com",
      "gender": "Female"
    }
    ])

OrderBy - sort 
Desc: -1
Asc: 1
db.products.find().sort({price:-1});

1st 2 skip and show 2 records
db.products.find().limit(2).skip(2);

db.products.find().limit(2);


// Indexing

//Aggregation - aggregation pipeline - For grouping
//chain of computing (select * -> where -> grouping-> sort -> limit)
// Aggregation is a way of processing a large number of documents in a collection by means of 
//passing them through different stages.
// [] - > for collection of operation 
//{} - for extend  memory 
//$match 
//$group [$max,$min,$avg,$sum,$push]
//$limit []
//$sort
//$project - 
//#skip - 
//$filter
//$unwind -> flatening the array
//$lookup

db.collectionNAme.aggregate([ 
    {},
])

db.users.aggregate([
    {$match:{name : "Mallika","age":30}}
]);

// db.users.aggregate([
//     {$match:{$or[{
//         {name : "Mallika",{"age":30}}
//     }]}}
// ]);


db.users.aggregate([
    {
        $group:{_id:"$city"}
    }
])

// sum = 1 occuring for result count 1 every times
db.users.aggregate([
    {
        $group:{_id:"$city","noOfPeaope":{$sum:1}}
    }
])

// adding the age and gruup 
db.users.aggregate([
    {
        $group:{_id:"$city","noOfPeaope":{$sum:"$age"}}
    }
])

db.users.aggregate([
    {
        $group:{_id:"$city","noOfPeaope":{$max:"$age"}}
    }
])

// maximum age but not grouping
//noOfPeaope : work as alias
db.users.aggregate([
    {
        $group:{_id:null,"noOfPeaope":{$max:"$age"}}
    }
])

//
db.users.aggregate([
    {
        $group:{_id:null,"noOfPeaope":{$max:"$age"}}
    }
])


// all users where age less than 30 and group by on  the basis of  city name 
db.users.aggregate([
    {$match:{age:{$lt:30}}},
    {$group:{_id:"$city","noOfPeaope":{$sum:1}}}
    ])


db.users.aggregate([
    {$group:{_id:null,"noOfPeaope":{$max:$age}}}
    ])

//Push always create array of $name
    db.users.aggregate([
    {$group:{_id:"$city","count":{$sum:1},"names":{$push:"$name"}}}
    ])

//fetch all name of users who are living in san Fransisco
  db.users.aggregate([
    {$group:{_id:"$city","count":{$sum:1},"names":{$push:"$name"}}},
    {$match:{_id:"Miami"}}
    ])


// it will show arrays of array of hobbies single properties
    db.users.aggregate([
    {$group:{_id:"$city","count":{$sum:1},"hobbies":{$push:"$hobbies"}}}
    ])

//push multiple columns - 

 db.users.aggregate([
    {$group:{_id:"$city","count":{$sum:1},"people":{$push:{"name":"$name","age":"$age","hobbies":"$hobbies"}}}}
    ])


//push the whole doc
 db.users.aggregate([
    {
        $group:{_id:"$city","count":{$sum:1},"people":{$push:"$$ROOT"}}
    }
    ])

//    Sorting 
db.users.aggregate([
    {
        $group:{_id:"$city","count":{$sum:1}}
    },
    {
        $sort:{count:1}
    }
])


//desc
db.users.aggregate([
    {
        $group:{_id:"$city","count":{$sum:1}}
    },
    {
        $sort:{count:-1}
    }
])


db.users.aggregate([
    {
        $group:{_id:"$city","count":{$sum:1},"name":{$push:"$name"}}
    },
    {
        $sort:{count:-1}
    }
])


// No need to show count
db.users.aggregate([
    {
        $group:{_id:"$city","count":{$sum:1},"name":{$push:"$name"}}
    },
    {
        $project:{count:0}
    }
])

db.users.aggregate([
    {
        $group:{_id:"$city","count":{$sum:1},"name":{$push:"$name"}}
    },
    {
        $sort:{count:1}
    },
     {
        $project:{count:0}
    },
])


db.users.aggregate([
    {
        $group:{_id:"$city","count":{$sum:1}}
    },
    {
        $sort:{count:-1}
    },
    {
        $skip : 1
    },
    {
        $limit : 4
    }
])


db.users.aggregate([
    {$sort:{age:1}}
])


//show only 1 hobbies
db.users.aggregate([
    {$match:{city:"San Francisco"}},
    {$unwind:"$hobbies"},
    {
        $limit : 4
    }
])


db.users.aggregate([
    {$match:{city:"San Francisco"}},
    {$unwind:"$hobbies"},
    {
        $limit : 3
    }
])


//Temp table with name demo where city name  = "San Francisco"
db.users.aggregate([
    {$match:{city:"San Francisco"}},
    {
        $limit : 4
    },
    {
        $out : "demo"
    }
])

//filter : 




lookup : Performs a left outer join to a collection in the same database to filter in documents 
from the "joined" collection for processing.
$lookup stage adds a new array field to each input documnet.



db.employees.insert({
    name:"Rosy",
    age:23,
    department_id:ObjectId('65b87b9984dda915def24dbc')
});

db.employees.insert({
    name:"Rosy",
    age:23,
    department_id:{
        "$oid": "65b87b9984dda915def24dbc" }
});

db.employees.aggregate([
    {
        $lookup:{
            from:"departments",  
            localField:"department_id",
            foreignField:"_id",
            as:"department"
        }
    },
    {
        $unwind:"$department"
    }
])


// many to 1
db.departments.aggregate([
    {
        $lookup:{
            from:"employees",  // Specifies the collection in the same database to perform the join with.
            localField:"_id",
            foreignField:"department_id",
            as:"employee"
        }
    }
])


//many to 1

db.departments.aggregate([
    {
        $lookup:{
            from:"employees",  // 
            localField:"_id",
            foreignField:"department_id",
            as:"employee"
        }
    },
    {
        $match:{employee:{$gt:{$size:0}}}
    }
])


//Many to many
db.departments.aggregate([
    {
        $lookup:{
            from:"employees",  //Specifies the collection in the same database to perform the join.
            localField:"employees",  // local field name from collection department
            foreignField:"_id", // field from the documents of the "form" collection // id which we are using from employees collection
            as:"employee"  // output array field
        }
    }
])


//Many TO Many and removed empty array of employees
db.departments.aggregate([
    {
        $lookup:{
            from:"employees",  //table name with which we are fetching data
            localField:"employees",  // local field name from collection department
            foreignField:"_id",  // id which we are using from employees collection
            as:"employee"
        }
    },
    {
        $match:{employee:{$gt:{$size:0}}}
    }
])


// It unwind the basisi of employees
db.departments.aggregate([
    {
        $lookup:
            {
            from: "employees",
            localField: "employees",
            foreignField: "_id",
            as: "employee"
            }
    },
    {$unwind:"$employee"}
    ]);


//check this
db.employees.aggregate([
    {
        $lookup:{
            from:"departments",  
            localField:"_id", 
            foreignField:"employees", 
            as:"department"
        }
    }
])

//Index
db.users.createIndex({city:1})

db.users.getIndexes()


// Single Index
 db.users.dropIndex("city_1");

 db.users.find({city:"San Francisco"}).explain("executionStats");

//Compound Index: index on multiple 
db.users.createIndex({age:1, city: 1 });

db.users.createIndexes([{age:1},{city: 1}]);

 db.users.find({age:{$gt:30}, city:"San Francisco"}).explain("executionStats");

 db.users.dropIndex("age_1_city_1");
// Result withOut Inddexing
     totalDocsExamined: 28,
       nReturned: 28,
//Result with Inddexing
 nReturned: 2,

db.users.find({name:"Mallika"})

db.users.updateOne({},{$set:{prop:{$inc:val}}})

db.users.updateMany({},{$inc:{age:10}})

db.users.updateOne({name:"Mallika"},{$set:{age:23,city:"Mumbai",gender:"Female",email:"mallika@gmail.com",hobbies:["Cricket"]}},{upsert:true})

// Atlas
// Filter
// 


//Practice
db.departments.aggregate([
    {
        $lookup:
            {
            from: "employees",
            localField: "employees",
            foreignField: "_id",
            as: "employee"
            }
    },{
    $match:{employee:{$gt:{$size:0}}}
    }
    ]);

db.employees.aggregate([
    {
        $lookup:
        {
            from: "departments",
            localField:"_id",
            foreignField:"employees",
            as: "department"
        }
    }
])

db.restaurants.find

db.restaurants.find({cuisine:{$eq:"American"}})

db.restaurants.find({ cuisine: {$eq:"American"}})



-- For normal filter we are using match But  we use filter under grouping and condition
// 
//filter 

db.users.find({hobbies:{$all:["Reading"]}})


db.users.aggregate([
{
     $project:{
        hobbies:{
            $filter:{
            input: "$hobbies",   // An expression that resolves to an array.
            as: "hobby",
            cond:{$eq:["$$hobby","Singing"]}
            }
        }
     }
}
])

db.users.aggregate([
    {
        $group:{_id:"$city"}},
     {  
       $project:{
        hobbies:{   
            $filter:{
            input: "$hobbies",   // An expression that resolves to an array.
            as: "hobby",
            cond:{$eq:["$$hobby","Singing"]}
            }
        }
     }
    }
])

db.candidates.insertMany([
    {
        "name":"Mallika",
        score:[23,43,21],
        age:25
    },
    {
    "name":"Radhika",
    score:[32,12,34],
    age:23
    }
])

// db.candidates.aggregate([
//     
//         $group:{_id:null, "avg":{$avg:{
//             score:{
//                 $project:{
//                     $filter:{
//                         input:"",
//                         as: ""
//                     }
//                 }
//             }
//         }}}
//     }
// ])


db.candidates.updateOne([
    {name:"Mallika"},
    {$set:
    {address:{city:"Mumbai",country:"India"}}
    }
])


// To add a new element ina  aarray inside the document

db.collectionName.updateOne({},{$push:{arrrayName:newEle}})

db.candidates.updateMany({},{}) 

db.candidates.updateOne({name:"Mallika"},{$push:{score:78}})




// aggregation,
// unwind, group 3
// lookup


















