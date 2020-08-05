http://localhost:8085/findCards?userNationalId=1122334455

[
    {
        "id": 9,
        "accountId": 5,
        "accountNumber": "33333333",
        "cardNumber": "6037-2910-2218-7777",
        "password": "7777",
        "secondPassword": "77777777",
        "cvv2": "777",
        "status": 1200,
        "expireMonth": "07",
        "expireYear": "99",
        "active": true
    },
    {
        "id": 10,
        "accountId": 6,
        "accountNumber": "44444444",
        "cardNumber": "5022-2910-2216-6666",
        "password": "6666",
        "secondPassword": "66666666",
        "cvv2": "666",
        "status": 1200,
        "expireMonth": "06",
        "expireYear": "98",
        "active": true
    }
]



=============================================
http://localhost:8085/addCard
post This jason

{
	"accountNumber":"33333333",
	"cardNumber": "6037-2910-2218-2222",
	"password":"2222",
	"secondPassword":"22222222",
	"cvv2":"222",
	"expireMonth":"02",
	"status":1200,
	"expireYear":"99"
}


=============================
http://localhost:8085/removeCard?cardNumber=5022-2910-2216-6666
response ==> true for remove
			false for don't remove