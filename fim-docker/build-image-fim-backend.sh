echo "开始构建 fim-backend 镜像..."

cp -rp ../target/fim-backend-*.jar ./fim-backend/

docker build -t fim-backend:1.0 ./fim-backend

rm -rf  ./fim-backend/fim-backend-*.jar
