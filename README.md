# Meter Your Calories Platform
## Product Service 

This service is composed by a service class that have all the business logic for creation, delete, update and get products. 
<br></br>Uses a Repository with the DAO to comunicate with the database. 

For the integrations with this service needs to make a HTTP request for the Product Controller. 
Product Controller has all the REST Interface to comunicate with Product Service. 

## Examples of the API

### List all Food Items [GET /food] 

List all food items available on the cafetaria.

Example Request:

<table>
    <tr>
        <th>Method</th>
        <td>GET</td>
    </tr>
    <tr>
        <th>Endpoint</th>
        <td> <a>http://localhost:8083/food</a> </td>
    </tr>
</table>

Example Response: 
````json
[
    {
        "name": "Coke",
        "food_group": "BEVERAGE",
        "calories": 150
    },
    {
        "name": "Fish and Chips",
        "food_group": "MAIN_COURSE",
        "calories": 1200
    },
    {
        "name": "Sour Lemonade",
        "food_group": "BEVERAGE",
        "calories": 12
    },
    {
        "name": "Cesar Salad",
        "food_group": "MAIN_COURSE",
        "calories": 450
    }
]
````

### Create Food Items [POST /food]

Create one or more food Item.

Example Request: 

<table>
    <tr>
        <th>Method</th>
        <td>POST</td>
    </tr>
    <tr>
        <th>Endpoint</th>
        <td> <a>http://localhost:8083/food</a> </td>
    </tr>
    <tr>
        <th>Content-type</th>
        <td> application/json </td>
    </tr>
</table>

body: 
````json
[
    {
        "name": "White Wine",
        "food_group": "BEVERAGE",
        "calories": 178
    },
    {
        "name": "Sushi",
        "food_group": "MAIN_COURSE",
        "calories": 1000
    }
]
````


Example Response:

````json
200 Ok
````

### Update Food Item [PUT /food/{name}]

Update structure of any food item available on the cafeteria.

Example Request: 

<table>
    <tr>
        <th>Method</th>
        <td>GET</td>
    </tr>
    <tr>
        <th>Endpoint</th>
        <td> <a>http://localhost:8083/food/Cesar Salad</a> </td>
    </tr>
    <tr>
        <th>Content-Type</th>
        <td>application/json</td>
    </tr>

</table>


Body: 
````json
    {
        "name": "Cesar Salad",
        "food_group": "MAIN_COURSE",
        "calories": 700              //change calories
    }
````



Example Response:
````json
200 OK
````



### Delete Food Items [DELETE /food/{name}]

Delete any food from the cafetaria list.

Example Request: 

<table>
    <tr>
        <th>Method</th>
        <td>DELETE</td>
    </tr>
    <tr>
        <th>Endpoint</th>
        <td> <a>http://localhost:8083/food/Coke</a> </td>
    </tr>
    <tr>
        <th>Content-Type</th>
        <td>application/json</td>
    </tr>

</table>

````json
200 ok
````