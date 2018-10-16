#!/usr/bin/env bash

oc login -u developer -p 123

oc delete project ece


while true
do
   oc new-project ece && break
   sleep 3
done


oc process -f https://raw.githubusercontent.com/jaegertracing/jaeger-openshift/master/all-in-one/jaeger-all-in-one-template.yml | oc create -f -

pushd ../ads && mvn clean fabric8:deploy -Popenshift

popd

mv src/main/fabric8/deployment.yml src/main/fabric8/deployment.y-not-ml