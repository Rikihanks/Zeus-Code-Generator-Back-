# Zeus Code Generator

Backend for the Zeus Code Generator project.


## Development environment.

Requires **Java and Maven** installed since this is an spring boot project.

**Steps:**
 - Clone the repo
 - Import as a Maven project to your Java IDE.
 - Run: `mvn clean install` or use the IDE tools to perform it easily.

## Usage

Backend will function on its own without external interference, ensure it launched at port 8080.

Zeus Code Generator, Zeus from now on, is a tool to generate the always repetitive code from Services, Interfaces and DTOs in a project that uses the DAO pattern.
It will take an input containing the Entity name, and its fields, much like you would define it in an Entity class in java, and it will generate the Services, Interfaces and DTOs asociated to that entity to save time and repetitive coding.

**Example entity input:**

    Post -> localhost:8080/generate
    {
    "idParamName":"identificador",
    "entityName":"Persona",
    "properties":{
    	"apellidos":"List<String>",
    	"longitud":"int",
    	"nombre":"String",
    	"identificador":"double"
	    }
    }
Where: 
**idParamName** => field referred to the primary key in the entity class.

**entityName** => Self explanatory.

**properties** => Map of key value (string, string) containing the rest of the entity fields.

This will generate a base64 text. When decoded it will be transformed into a .zip file ready for download.