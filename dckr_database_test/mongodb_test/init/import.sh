#! /bin/bash

mongoimport --host mongo_db_test --username root --password password --authenticationDatabase admin --db mediscreen_test_oc_mc --collection patientsMedicalRecords --type json --file /src/data/init_db_test.json --jsonArray