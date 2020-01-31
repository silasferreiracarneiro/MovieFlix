package br.com.silas.carneiro.movieflix.di.module

import androidx.appcompat.app.AppCompatActivity
import dagger.Module

@Module
class PresenterModule(var appCompatActivity: AppCompatActivity) {
}