CREATE TABLE `movie`
(
    `id`             INT NOT NULL,
    `title`          VARCHAR(20)   DEFAULT NULL,
    `original_title` VARCHAR(100)  DEFAULT NULL,
    `rating`         DECIMAL(3, 1) DEFAULT NULL,
    `genres`         VARCHAR(20)   DEFAULT NULL,
    `year`           VARCHAR(4)    DEFAULT NULL,
    `pubdates`       VARCHAR(100)  DEFAULT NULL,
    `image`          VARCHAR(100)  DEFAULT NULL,
    `summary`        VARCHAR(1000) DEFAULT NULL,
    `durations`      VARCHAR(100)  DEFAULT NULL,
    `photos`         VARCHAR(1000) DEFAULT NULL,
    `album`          VARCHAR(100)  DEFAULT NULL,
    `cast`           VARCHAR(100)  DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8