package com.kelway.pizzashop

import android.content.Context
import com.kelway.pizzashop.data.di.DataModule
import com.kelway.pizzashop.data.di.RoomModule
import com.kelway.pizzashop.domain.di.DomainModule
import com.kelway.pizzashop.presentation.menu.MenuFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [DataModule::class, DomainModule::class, RoomModule::class]
)

interface AppComponent {
    fun inject(target: MenuFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun buildContext(context: Context): Builder
        fun build(): AppComponent
    }
}