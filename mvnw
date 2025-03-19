#!/usr/bin/env sh

# Maven wrapper script for Unix

set -e

MAVEN_OPTS="${MAVEN_OPTS:-}"

# Determine the location of the Maven wrapper jar
WRAPPER_JAR="$(dirname "$0")/mvnw.jar"

# Check if the wrapper jar exists
if [ ! -f "$WRAPPER_JAR" ]; then
  echo "Error: Maven wrapper jar not found. Please run 'mvn -N io.takari:maven:wrapper' to generate it."
  exit 1
fi

# Execute the Maven wrapper with the provided arguments
exec java $MAVEN_OPTS -jar "$WRAPPER_JAR" "$@"