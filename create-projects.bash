#!/usr/bin/env bash

mkdir course-microservices
cd course-microservices

spring init \
--boot-version=3.3.2 \
--type=gradle-project \
--java-version=21 \
--packaging=jar \
--name=course-service \
--package-name=se.aymeric.microservices.core.course \
--groupId=se.aymeric.microservices.core.course \
--dependencies=actuator,webflux \
--version=1.0.0-SNAPSHOT \
course-service

spring init \
--boot-version=3.3.2 \
--type=gradle-project \
--java-version=21 \
--packaging=jar \
--name=review-service \
--package-name=se.aymeric.microservices.core.review \
--groupId=se.aymeric.microservices.core.review \
--dependencies=actuator,webflux \
--version=1.0.0-SNAPSHOT \
review-service

spring init \
--boot-version=3.3.2 \
--type=gradle-project \
--java-version=21 \
--packaging=jar \
--name=recommendation-service \
--package-name=se.aymeric.microservices.core.recommendation \
--groupId=se.aymeric.microservices.core.recommendation \
--dependencies=actuator,webflux \
--version=1.0.0-SNAPSHOT \
recommendation-service

spring init \
--boot-version=3.3.2 \
--type=gradle-project \
--java-version=21 \
--packaging=jar \
--name=course-composite-service \
--package-name=se.aymeric.microservices.composite.course \
--groupId=se.aymeric.microservices.composite.course \
--dependencies=actuator,webflux \
--version=1.0.0-SNAPSHOT \
course-composite-service

cd ..
