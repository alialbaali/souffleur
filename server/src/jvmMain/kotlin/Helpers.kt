package eu.thomaskuenneth.souffleur

import java.net.*
import java.util.*
import java.util.logging.Level

// See https://stackoverflow.com/a/69160376
fun setDeviceAndAddress(viewModel: ViewModel) {
    try {
        DatagramSocket().use { s ->
            val remoteAddress = InetAddress.getByName("a.root-servers.net")
            if (remoteAddress != null) {
                s.connect(remoteAddress, 80)
                viewModel.address = s.localAddress.hostAddress
                viewModel.device = NetworkInterface.getByInetAddress(s.localAddress).displayName
            }
        }
    } catch (e: UnknownHostException) {
        LOGGER.log(Level.SEVERE, null, e)
    } catch (e: SocketException) {
        LOGGER.log(Level.SEVERE, null, e)
    }
}

private val osNameLowerCase = System.getProperty("os.name", "").lowercase(Locale.getDefault())

val IS_MACOS = osNameLowerCase.contains("mac os x")
