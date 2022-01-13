FROM ghcr.io/graalvm/graalvm-ce:latest
RUN gu install native-image
WORKDIR /native_image
CMD ["sh", "java2bin.sh"]
