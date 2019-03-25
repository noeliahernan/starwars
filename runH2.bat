@ECHO OFF
ECHO Configuracion del DS necesaria en build.gy
ECHO         url = 'jdbc:h2:tcp://localhost:9092/./h2/starwars'
ECHO         driverClassName = 'org.h2.Driver'
ECHO -
ECHO Puedes ver la BD en la ventana del navegador que se te abrira
ECHO         Pon ahi como url jdbc: jdbc:h2:tcp://localhost:9092/./h2/starwars (la misma que en build.gy)
ECHO         Y como usuario y pass: ESPUBLICO (las mismas que en build.gy)
ECHO -
java -jar h2/h2-1.4.196.jar -webAllowOthers -tcpAllowOthers