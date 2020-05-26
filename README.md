# mid-mod3-springboot

Personal Protection Equipment

 * This project displays the available PPE inventory in each city.
 
 How to setup
 
 * Download source code
 * create a postgres database on the machine with name "ppe_db"
 * Run springboot application
 
 Apis
 
 PPE Inventory:
 
  * GET /ppe_api/v1/ppedata - Retrieves all
  * POST /ppe_api/v1/pperecords - creates new city inventory
  * PUT /ppe_api/v1/pperecords/{cityName} - updates inventory
  * GET /ppe_api/v1/pperecords/{cityName} - Retrieves specific city inventory.
  * DELETE /ppe_api/v1/pperecords/{cityName} - Deletes city inventory
  
  
  City:
  
  * GET /ppe_api/v1/citynames - Retrieves all city names
  * POST /ppe_api/v1/citynames - Creates new city name
  * DELETE /ppe_api/v1/citynames/{cityName} - Deletes city name
  * GET /ppe_api/v1/citynames/{cityName} - Retrieves city details
  
   
  