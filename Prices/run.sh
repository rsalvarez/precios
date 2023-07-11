docker stop prices
docker rm -fv prices
docker run -d -it -p 8080:8080 --name prices prices
