package com.giacomoparisi.data.error

import com.giacomoparisi.domain.datatype.LazyData
import retrofit2.HttpException

suspend fun <T> Throwable.toError(errorMapper: ErrorMapper, value: T? = null): LazyData.Error<T> =
    LazyData.Error(errorMapper.map(this), value)