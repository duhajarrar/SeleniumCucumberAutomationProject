#ZEPHYR_SQUAD_API_URL="https://prod-api.zephyr4jiracloud.com/v2"
ZEPHYR_SQUAD_API_URL="https://api.zephyrscale.smartbear.com/v2"
#ZEPHYR_SQUAD_API_KEY="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb250ZXh0Ijp7ImJhc2VVcmwiOiJodHRwczovL2pvYnNwcy5hdGxhc3NpYW4ubmV0IiwidXNlciI6eyJhY2NvdW50SWQiOiI1NTcwNTg6M2Y5ZDk3YjktMjgyZC00NDAzLWE4Y2EtNDY2ZTUzZTIxNDVhIn19LCJpc3MiOiJjb20udGhlZC56ZXBoeXIuamUiLCJzdWIiOiIwNTQ1ZTMxYi1mZjk5LTMxMmYtOTg5OS1kZWNlYWY4ZjdjNmYiLCJleHAiOjE3MzY0MjE5NTcsImlhdCI6MTcwNDg4NTk1N30.6_b4YPsPPv3JYjRerlhFiFBxfJIAziCJPxFuk63OYLY"
ZEPHYR_SQUAD_API_KEY="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb250ZXh0Ijp7ImJhc2VVcmwiOiJodHRwczovL2pvYnNwcy5hdGxhc3NpYW4ubmV0IiwidXNlciI6eyJhY2NvdW50SWQiOiI1NTcwNTg6M2Y5ZDk3YjktMjgyZC00NDAzLWE4Y2EtNDY2ZTUzZTIxNDVhIn19LCJpc3MiOiJjb20ua2Fub2FoLnRlc3QtbWFuYWdlciIsInN1YiI6IjA1NDVlMzFiLWZmOTktMzEyZi05ODk5LWRlY2VhZjhmN2M2ZiIsImV4cCI6MTczNjQ1NDA5MSwiaWF0IjoxNzA0OTE4MDkxfQ.Wo4fYDLDLgS5XULUXQ3f8-FmTjSKJT7836lzYV-bXNM"

PROJECT_KEY="JT"
BUILD_DIR="../"
PATH_FILE="Reports/cucumber/*.json"
ZIP_FILE="test_result.zip"
AUTO_CREATE_TEST_CASES="false"

echo "Removing old zip files"
rm -f $BUILD_DIR/$ZIP_FILE

echo "Creating new zip file"
zip $BUILD_DIR/$ZIP_FILE $BUILD_DIR/$PATH_FILE -j

echo "Sending zip file to Zephyr Squad" 
 
 curl --request POST \
  --url "$ZEPHYR_SQUAD_API_URL/automations/executions/cucumber?projectKey=$PROJECT_KEY&autoCreateTestCases=$AUTO_CREATE_TEST_CASES" \
  -v \
  --header "Accept: application/json" \
  --header "Authorization: $ZEPHYR_SQUAD_API_KEY" \
  --header "Content-Type: multipart/form-data" \
  --form "file=@$BUILD_DIR/$ZIP_FILE;type=multipart/form-data" \
  --form "testCycle={\"name\":\"Automated Test Cycle\",\"description\":\"Automated Test Using BDD Automated Test\",\"details\":{\"folder\":\"/Test\"}};type=application/json"
 
echo "Finished"