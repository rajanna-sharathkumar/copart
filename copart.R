rm(list=ls())
setwd(dirname(rstudioapi::getActiveDocumentContext()$path))

summary(zip_codes_states)

data <- na.omit(zip_codes_states)
summary(data)

new_data <- data[c("latitude","longitude")]

?kmeans
k_means <- kmeans(new_data,10,nstart = 2)
summary(k_means)