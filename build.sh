#!/bin/bash

mvn package

java -jar target/servidor-central-0.0.1-SNAPSHOT.jar
