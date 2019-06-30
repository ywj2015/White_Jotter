<template>
    <div>
        <side-menu class="side-menu"></side-menu>
        <div class="home">
            <div id="header">
                <div style="height: 180px"></div>
                <carousel></carousel>
                <quick-nav class="quick-nav"></quick-nav>
            </div>
            <update-card></update-card>
            <slogan></slogan>
            <about class="about"></about>
        </div>
    </div>
</template>

<script>
import SideMenu from './SideMenu'
import Carousel from './Carousel'
import QuickNav from './QuickNav'
import Slogan from './Slogan'
import UpdateCard from './UpdateCard'
import About from '../common/About'

export default {
    name: "AppIndex",
    components: {
        SideMenu, Carousel, QuickNav, Slogan, UpdateCard, About
    }
}
</script>

<style scoped>
    .side-menu {
        /* margin-left: 20px; */
        position: fixed;
        margin-left: 50%;
        left: -650px;
        top: 90px;
    }

    .home {
        width: 990px;
        margin-left: 215px;
        margin-right: auto;
        margin-top: -12px;
        /* margin-left: -20px; */
    }

    #header {
        /* padding-top: 20px; */
        padding-bottom: 20px;
        padding-left: 5px; 
        background-color: white;
    }

    .quick-nav {
        float: right;
        margin-top: -450px;
        margin-right: 480px;
    }

    .about {
        height: 20px;
    }
</style>

