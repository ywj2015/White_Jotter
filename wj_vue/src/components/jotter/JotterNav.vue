<template>
    <div>
        <el-row class="tac">
            <h4>科目</h4>
            <el-menu
                default-active="2"
                class="el-menu-vertical-demo"
                @open="handleOpen"
                @close="handleClose"
                background-color="#545c64"
                text-color="#fff"
                active-text-color="#ffd04b">
                <el-submenu index="1">
                <template slot="title">
                    <i class="el-icon-menu"></i>
                    <span>新建文件</span>
                </template>
                <el-menu-item-group>
                    <el-menu-item index="1-1">新建md文件</el-menu-item>
                    <el-menu-item index="1-2">新建Word文档</el-menu-item>
                    <el-menu-item index="1-3">新建Excel文件</el-menu-item>
                </el-menu-item-group>
                </el-submenu>
                <el-menu-item index="3">
                <i class="el-icon-document"></i>
                <span slot="title">我的文件夹</span>
                </el-menu-item>
                <el-menu-item index="4">
                <i class="el-icon-setting"></i>
                <span slot="title">文件上传/分享</span>
                </el-menu-item>
                <el-menu-item index="5">
                <i class="el-icon-circle-plus-outline" style="color: white"></i>
                </el-menu-item>
            </el-menu>
      </el-row>
    </div>
</template>

<script>
  export default {
    name: 'JotterNav',
    methods: {
      handleOpen (key, keyPath) {
        console.log(key, keyPath)
      },
      handleClose (key, keyPath) {
        console.log(key, keyPath)
      }
    }
  }
</script>