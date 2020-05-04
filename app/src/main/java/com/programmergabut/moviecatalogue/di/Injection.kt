package com.programmergabut.moviecatalogue.di

import com.programmergabut.moviecatalogue.data.repository.MCRepository

object Injection {

    fun provideRepository(): MCRepository = MCRepository.getInstance()

}