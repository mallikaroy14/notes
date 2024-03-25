//

students (name,city,hobbies, age)


student -> 1 array and pass id of courses type ObjectId

courses{name, fees, duration}

db.createCollection('students',{
    validator:{
        $jsonSchema:{
            type:"object",
            required:["name","city","hobbies","age"],
            properties:{
                name:{
                    bsonType:"string",
                    description:"student name",
                    maxLength:20
                },
                city:{
                    bsonType:"string",
                    description:"city name",
                    maxLength:20
                },
                hobbies:{
                    bsonType:"array",
                    description:"array of hobbies",
                    minItems:1,
                    maxItems:3,
                    items:{
                        type:"string"
                    }
                },
                age:{
                    bsonType:"number",
                    description:"student age",
                    minimum:4,
                    maximum:100
                },
                coursesId:{
                    type:"array",
                    description:"course id",
                    minItems:1,
                    maxItems:3,
                    items:{
                        bsonType:"objectId"
                    }
                }
            }
        }
    }
});

db.students.drop();

db.students.insertMany([
    {name:"Mallika", city:"Mumbai", hobbies:["painting","cricket"],age:23,courses_id:[ObjectId('65b9e7552dc3960bf628a249'), ObjectId('65b9e7552dc3960bf628a24d')]}, 
    {name:"Rosy", city:"Pune", hobbies:["painting","volleyball"],age:26,courses_id:[ObjectId('65b9e7552dc3960bf628a249')]}, 
    {name:"Kumud", city:"Delhi", hobbies:["cooking","craft"],age:28,courses_id:[ObjectId('65b9e7552dc3960bf628a24b')]}, 
    {name:"Rahul", city:"Pune", hobbies:["study","basketball"],age:29,courses_id:[ObjectId('65b9e7552dc3960bf628a24d'), ObjectId('65b9e7552dc3960bf628a24b')]}
])

db.createCollection('courses');

db.courses.insertMany([
   { name:"FSD", fees:"50000",duarion:"56"},
   { name:"Java", fees:"3000",duration:"20"},
   { name:"Android", fees:"5000",duration:"30"},
   { name:"Flutter", fees:"4000",duration:"20"},
    {name:"NodeJS", fees:"6000",duration:"30"}
])


1. all students with their courses

db.students.aggregate({
    $lookup:{
        from:"courses",
        localField:"courses_id",
        foreignField:"_id",
        as:"student"
    }
})

2. all students who have hobby cricket dont include courses

db.students.find({
    hobbies:"cricket"
},{
    courses_id:0
}
)

3. count of students for each city

db.students.aggregate({
    $group:{_id:"$city","count":{$sum:1}}
})

4. count of student for each courses

db.courses.aggregate([
    {$lookup:{
        from:"students",
        localField:"_id",
        foreignField:"courses_id",
        as:"students"
    }
},{
    $unwind: "$students"
},
{
    $group:{_id:"$name","count":{$sum:1}}
}
])


db.courses.aggregate([
    {$lookup:{
        from:"students",
        localField:"_id",
        foreignField:"courses_id",
        as:"students"
    }
},
{
    $project:{
        "students_count":{$size:"$students"}, name:1,fees:1, duration:1
    }
}
])



product
name,price



customers(name, purchase [product_id])


review
rating
custumer_id
product_id


order(product_id,custumer_id) 

db.createCollection('mongodb')

db.products.insertMany([
    {"name":"pen","price":"30" },
    {"name":"copy","price":"80" },
     {"name":"book","price":"40" },
      {"name":"water bottel","price":"50" },
       {"name":"plate","price":"870" },
        {"name":"key","price":"770" },
   ]
    )

db.customers.insertMany([
{"name":"Mallika","purchase":[ObjectId('65bb343c56af49e68efe5984'),ObjectId('65bb343c56af49e68efe5985')] },
{"name":"Rosy","purchase":[ObjectId('65bb343c56af49e68efe5986'),ObjectId('65bb343c56af49e68efe5985')] },
{"name":"Nagy","purchase":[ObjectId('65bb343c56af49e68efe5983'),ObjectId('65bb343c56af49e68efe5985')] },
{"name":"Ruby","purchase":[ObjectId('65bb343c56af49e68efe5982'),ObjectId('65bb343c56af49e68efe5985')] },
{"name":"Renu","purchase":[ObjectId('65bb343c56af49e68efe5981'),ObjectId('65bb343c56af49e68efe5985')] }
])

db.reviews.insertMany(
[
    {rating:4,product_id: ObjectId('65bb343c56af49e68efe5984') ,custumer_id:ObjectId('65bb360d17310f3f3f631b10') },
    {rating:3,product_id: ObjectId('65bb343c56af49e68efe5981') ,custumer_id:ObjectId('65bb360d17310f3f3f631b12') },
    {rating:9,product_id: ObjectId('65bb343c56af49e68efe5982') ,custumer_id:ObjectId('65bb360d17310f3f3f631b14') },
    {rating:8,product_id: ObjectId('65bb343c56af49e68efe5985'),custumer_id:ObjectId('65bb360d17310f3f3f631b11') },
    {rating:7,product_id: ObjectId('65bb343c56af49e68efe5984') ,custumer_id:ObjectId('65bb360d17310f3f3f631b13') }
]
)


db.orders.insertMany(
[
    {quantity:3,product_id: ObjectId('65bb343c56af49e68efe5984') ,custumer_id:ObjectId('65bb360d17310f3f3f631b10') },
    {quantity:3,product_id: ObjectId('65bb343c56af49e68efe5981') ,custumer_id:ObjectId('65bb360d17310f3f3f631b12') },
    {quantity:9,product_id: ObjectId('65bb343c56af49e68efe5982') ,custumer_id:ObjectId('65bb360d17310f3f3f631b14') },
    {quantity:8,product_id: ObjectId('65bb343c56af49e68efe5985'),custumer_id:ObjectId('65bb360d17310f3f3f631b11') },
    {quantity:7,product_id: ObjectId('65bb343c56af49e68efe5984') ,custumer_id:ObjectId('65bb360d17310f3f3f631b13') }
]
)

db.reviews.drop()

db.reviews.find()
db.customers.find()
db.orders.find()
db.products.find()

// customeredIds: {
//     '0': ObjectId('65bb360d17310f3f3f631b10'),
//     '1': ObjectId('65bb360d17310f3f3f631b11'),
//     '2': ObjectId('65bb360d17310f3f3f631b12'),
//     '3': ObjectId('65bb360d17310f3f3f631b13'),
//     '4': ObjectId('65bb360d17310f3f3f631b14')

//1. Retrieve all documents from the ""products"" collection where the ""price"" is greater than $50."

    db.products.find(
        {price:{$gt:50}}
        );

// 2. Use the aggregation framework to find the average ""rating"" for all documents in the ""reviews"" 
// collection grouped by the ""product_id."""
db.reviews.aggregate([
    {
        $group:{_id:"$product_id", "averageRating":{$avg:"$rating"}}
    }
])

// 3 Count the number of documents in the ""orders"" collection for each unique value in the ""customer_id"" field. Display the
//  results with the customer ID and the corresponding count."

db.orders.aggregate([
    {
        $group:{_id:"$custumer_id","count":{$sum:1}}
    }
])


// 4. Project only the ""name"" and ""totalSales"" fields from the ""customers"" collection. 
// Calculate the total sales
//  (totalSales) for each customer, summing up the values in the ""purchases"" array. Sort the results in descending order 
//  based on the total sales."

db.customers.aggregate([
    {
      $lookup:{
        from:"orders",
        localField:"purchase",
        foreignField:"product_id",
        as:"purchase"
    } 
    },
    {
        $unwind:"$purchase"
    },{
        $group:{_id:"$name",totalSales:{$sum:1}} 
    },
    {
        $project:{name:"$_id",totalSales:1,_id:0}
    },{
        $sort:{totalSales:-1}
    }
])

// Find the average quantity of each item sold in the ""sales"" collection. Consider using the $unwind stage to flatten the
//  ""items"" array before calculating the average quantity"

db.orders.aggregate([
    {
        $group:{_id:"$product_id", avgQuantity:{$avg:"$quantity"}}
    }
])


























