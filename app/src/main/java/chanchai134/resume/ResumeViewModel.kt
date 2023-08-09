package chanchai134.resume

import androidx.lifecycle.ViewModel
import chanchai134.resume.ui.navigation.Destination

class ResumeViewModel : ViewModel() {
    /* this is not state (don't need recomposition) but is a cache value
     * needed to retain configuration change */
    var currentDestination: Destination = Destination.Home
        private set

    fun setCurrentDestination(destination: Destination) {
        currentDestination = destination
    }
}
