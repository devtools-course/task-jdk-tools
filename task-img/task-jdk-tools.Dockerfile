FROM ghcr.io/1bah/fenrir-base:latest AS fenrir

FROM openjdk:25-rc-jdk-slim-bookworm
LABEL authors="lBAH, Kalinin Iwan <koefic.cien@gmail.com>"

RUN apt update && apt install --no-install-recommends -y \
        git \
        shellcheck \
        procps \
        curl \
    && apt clean \
    && useradd -G sudo -m -s "/bin/bash" fikus

WORKDIR /home/fikus

COPY --from=fenrir /usr/local/bin/fenrir* /usr/local/bin/
COPY --from=fenrir /usr/local/bin/loki /usr/local/bin/
COPY --from=fenrir --chown=fikus:fikus /etc/fenrir /etc/fenrir
COPY --from=fenrir --chown=fikus:fikus /home/fikus/.fenrir /home/fikus/.fenrir

USER fikus

ENTRYPOINT [ "top", "-b" ]
