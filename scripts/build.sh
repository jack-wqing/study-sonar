#!/usr/bin/env bash

declare image='swr.cn-north-4.xxx.com/zs-base/sonarqube-enterprise:25.4-v1'
declare image_latest='swr.cn-north-4.xxx.com/zs-base/cicd-base:latest'

# login harbor:
docker login -u cn-north-4@$ak -p $sk  swr.cn-north-4.myhuaweicloud.com
docker build \
    --no-cache \
    -t ${image} \
    -f Dockerfile \
    .

docker push ${image}

# docker tag ${image} ${image_latest}

# docker push ${image_latest}