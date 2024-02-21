# securerestapi
Testing Curl Urls
============================
curl --location 'http://localhost:8500/api/signup' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "abcd@gmail.com",
    "password": "abc"
}'
=============================
curl --location 'http://localhost:8500/api/signin' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "abcd@gmail.com",
    "password": "abc"
}
===============================
curl --location 'http://localhost:8500/api/test' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhYmNAZ21haWwuY29tIiwiaWF0IjoxNzA4NDkzMjAwLCJleHAiOjE3MDg1MDA0MDB9.-UfRbYvwYtt_m9ZdMSITb-rMWcg_SbmcP_5589I1ad-OLKzs2rngUQ5nOxTGLwkEabD0FJg4SgVpGoKATCHKUw'
===============================
curl --location 'http://localhost:8500/api/refresh' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhYmNAZ21haWwuY29tIiwiaWF0IjoxNzA4NDkzMjAwLCJleHAiOjE3MDg1MDA0MDB9.-UfRbYvwYtt_m9ZdMSITb-rMWcg_SbmcP_5589I1ad-OLKzs2rngUQ5nOxTGLwkEabD0FJg4SgVpGoKATCHKUw' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email":"abc@gmail.com",
    "refreshToken":"dfsa"
}'
====================================
