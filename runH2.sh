echo "Configuracion del DS necesaria en build.gy"
echo "        url = 'jdbc:h2:tcp://localhost:9092/./h2/starwars'"
echo "        driverClassName = 'org.h2.Driver'"
echo "-"
echo "Puedes ver la BD en la ventana del navegador que se te abrira"
echo "        Pon ahi como url jdbc: jdbc:h2:tcp://localhost:9092/./h2/starwars (la misma que en build.gy)"
echo "        Y como usuario y pass: ESPUBLICO (las mismas que en build.gy)"
echo "-"
java -jar h2/h2-1.4.196.jar -webAllowOthers -tcpAllowOthers