# shellcheck disable=SC2035
directory="../protos"
if [ -d "$directory" ]; then
  rm -rf ../protos
  echo "Directory deleted: $directory"
fi
mkdir "$directory"
echo "Directory created: $directory"
protoc --java_out=../protos *.proto
echo "generate message successful"
protoc --plugin=protoc-gen-grpc-java=./protoc-gen-grpc-java-1.54.1-osx-x86_64.exe --grpc-java_out=../protos *.proto
echo "generate service successful"
