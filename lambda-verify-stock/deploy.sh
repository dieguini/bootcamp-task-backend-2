#!/bin/bash
set -eo pipefail
ARTIFACT_BUCKET='dj-athena-s3'
TEMPLATE=template.yml
AWS_PROFILE=$1
STACK_NAME="dj-athena-sn"

aws cloudformation package --template-file $TEMPLATE --s3-bucket $ARTIFACT_BUCKET --output-template-file out.yml --profile $AWS_PROFILE
aws cloudformation deploy --template-file out.yml --stack-name $STACK_NAME --capabilities CAPABILITY_NAMED_IAM --profile $AWS_PROFILE
