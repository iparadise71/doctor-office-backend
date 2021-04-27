# doctor-office-backend
Requisitos: 
        
        * Mysql 8.0.23
        * Java 11
        
pasos de instalacion:

        1. Ejecutar script creacion de BD doctordb.sql
        2. Opcional
             Ejecutar script creacion datos doctores insertDoctors.sql
             Ejecutar script creacion datos pacientes insertPatients.sql
CONFIGURACION

        1. actualizar credenciales de BD MySQL
            resources/application.properties
                
                spring.datasource.username = #USUARIO
                spring.datasource.password = #CONTRASEÑA
      
            
BUILD 

        1. ejecutar comando 
            comando:  gradle build
        2. ejecutar el archivo generado build/libs/doctor-office-0.0.1-SNAPSHOT.jar
            comando:  java -jar doctor-office-0.0.1-SNAPSHOT.jar
            
NOTA: 
    
      Puerto: 9001
        
        
