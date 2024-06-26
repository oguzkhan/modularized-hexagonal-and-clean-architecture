REM create sample films
curl -v -H "Content-Type:application/json" -d "{\"name\":\"Dünyayı Kurtaran Adam\"}" -X POST http://localhost:7000/api/v1/films
REM get all films
curl -v -H "Content-Type:application/json" -X GET http://localhost:7000/api/v1/films