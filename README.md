# MicroProfile with Thorntail

A demo app showing how to run a MP service on Kubernetes and how to use the following MicroProfile features in Thorntail:
* MP Config with Kubernetes ConfigMap
* Fault Tolerance
* Health

The demo consists of two services, ads that serves advertisements and quotes that serves quotes with one advertisement on the top.

The ads service is already ready for all the steps of the demo. 
The specific steps that correspond to the [commits](https://github.com/michalszynkiewicz/mp-on-kubernetes/commits/master), are made on the quotes app

To run an application run the following in an application directory:
```
mvn clean fabric8:deploy -Popenshift
```
The demo used http://minishift.io 
You have to be logged in to minishift before running the command above.

[Click here to download slides for the accompanying presentation](https://github.com/michalszynkiewicz/mp-on-kubernetes/raw/master/EclipseCon:%20Cloud%20Native%20development%20with%20Eclipse%20Microprofile%20on%20Kubernetes.pdf)

Recording of the presentation: https://www.youtube.com/watch?v=EJ-AsOCWWvk
