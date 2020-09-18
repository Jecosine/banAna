/*
 * @Date: 2020-08-27 01:08:38
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-27 02:00:55
 */
var nv = {
    props: ['reachtop', 'swidth', 'user'],
    template: `
    <div id="navigation-container" class="general-shadow" :style="{'backgroundColor':(onTop)?'transparent':'white'}">
    <!-- <div id="navigation-mask"></div> -->
    <div class="navigation-wrapper">
        <div class="inline-block" id="collapser" v-show="screenWidth < 1200">
            <el-button @click="isCollapsed = !isCollapsed" :icon="(isCollapsed)?'el-icon-s-unfold':'el-icon-s-fold'"
                circle></el-button>
        </div>
        <div id="logo" class="inline-block" :style="{left: (screenWidth < 1200)?'60px':'0'}">
            <a href="/">
                <el-image style="width: 110px" src="/img/logo.png" fit="contain"></el-image>
            </a>
        </div>
        <transition name="fade">
            <!-- <div id="navigation-right" class="inline-block float-right"> -->
            <el-menu v-show="(screenWidth > 1200) || isCollapsed"
                :mode="(screenWidth > 1200)?'horizontal':'vertical'" :default-active="activeIndex"
                :class="{ 'float-right':screenWidth > 1200, 'mobile-menu':screenWidth <= 1200}"
                @select="handleSelect"
                :style="{'backgroundColor':(onTop)?(screenWidth > 1200)?'transparent':'white':'white'}"
                @scrollleavetop="handleLeaveTop" collapse-transition="false">

                <el-submenu index="1">
                    <template slot="title">
                        <i class="el-icon-service"></i>
                        <span>Service</span>
                    </template>
                    <el-menu-item index="4-1">Feed Back</el-menu-item>
                    <el-menu-item index="4-2">My Service</el-menu-item>
                </el-submenu>
                <el-menu-item index="2"><i class="el-icon-thumb"></i><span>About Us</span></el-menu-item>
                <!-- </el-menu> -->
                <!-- <el-menu :default-active="activeIndex" class="inline-block float-right" mode="horizontal" @select="handleSelect"> -->
                <!-- <div class="float-right"> -->
                <el-menu-item index="3"><a href="#" target="_blank"><i class="el-icon-tickets"></i><span>All
                            Orders</span></a></el-menu-item>
                <el-menu-item index="4"><i class="el-icon-shopping-cart-1"></i><span>Shop Cart</span></el-menu-item>
                <el-menu-item index="5"><i class="el-icon-bell"></i><span>Notifications</span></el-menu-item>
                <el-submenu index="6">
                    <template slot="title">
                        <el-avatar :size="40" :src="userData.avatarUrl"></el-avatar>
                    </template>
                    <el-menu-item index="6-1" @click="window.location.href='/personal?tab=1'"><i class="el-icon-user"></i> My Profile</el-menu-item>
                    <el-menu-item index="6-2" @click="window.location.href='/personal?tab=6'"><i class="el-icon-bank-card"></i> Gift Cards</el-menu-item>
                    <el-menu-item index="6-3" @click="window.location.href='/personal?tab=7'"><i class="el-icon-setting"></i> Settings</el-menu-item>
                </el-submenu>
                <!-- </div> -->
            </el-menu>
        </transition>
    </div>
</div>
    `,
    data() {
        return {
            isCollapsed: false,
            activeIndex: '1',
            activeIndex2: '1',
            onTop: this.reachtop,
            screenWidth: this.swidth,
            userData: this.user
        }
    },
    watch: {
        reachtop(val) {
            this.onTop = val;
        },
        swidth(val) {
            this.screenWidth = val;
        },
        user(val) {
            this.userData = val;
        }
    },
    methods: {
        handleSelect(key, keyPath) {
            console.log(key, keyPath);
        },
        handleOnTop(a)
        {
            // console.log("to top!", a);
            this.onTop = true;
        },
        handleLeaveTop()
        {
            this.onTop = false;
            console.log("leave top!");
        }
    }
};